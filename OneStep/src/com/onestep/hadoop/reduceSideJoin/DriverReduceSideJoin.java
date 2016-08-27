package com.onestep.hadoop.reduceSideJoin;

import java.net.URI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.Logger;

public class DriverReduceSideJoin extends Configured implements Tool{

	private static final Logger LOG = Logger.getLogger(DriverReduceSideJoin.class);
	
	@Override
	public int run(String[] args) throws Exception {
		if (args.length != 4) {
			System.out
					.printf("Three parameters are required for DriverRSJ- <input dir1> <input dir2> <output dir>\n");
			return -1;
		}
		
		LOG.info("Driver what the fuck is going on");		
		Configuration conf = getConf();
		DistributedCache.addCacheFile(new Path(args[3]).toUri(), conf);
		
		conf.setInt("part-e", 1);// Set Employee file to 1
		conf.setInt("part-sc", 2);// Set Current salary file to 2
		conf.setInt("part-sh", 3);// Set Historical salary file to 3
		
		Job job = new Job(conf);
		job.setJarByClass(DriverReduceSideJoin.class);
		job.setJobName("ReduceSideJoin");
		Path outPath = new Path(args[2]);
		
		
		
		StringBuilder inputPaths = new StringBuilder();
		inputPaths.append(args[0].toString()).append(",")
				.append(args[1].toString());
		
		FileInputFormat.setInputPaths(job, inputPaths.toString());
		FileOutputFormat.setOutputPath(job, outPath);
		
		job.setMapperClass(MapperRSJ.class);
		LOG.info("Driver what the fuck is going on mapper");	
		job.setMapOutputKeyClass(CompositeKeyWritableRSJ.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setPartitionerClass(PartitionerRSJ.class);
		job.setSortComparatorClass(SortingComparatorRSJ.class);
		job.setGroupingComparatorClass(GroupingComparatorRSJ.class);

		job.setNumReduceTasks(4);
		job.setReducerClass(ReducerRSJ.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileSystem fs = FileSystem.newInstance(getConf());

		if (fs.exists(outPath)) {
			fs.delete(outPath, true);
		}

		
		boolean success = job.waitForCompletion(true);
		return success ? 0 : 1;
	}
	
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new Configuration(), new DriverReduceSideJoin(),
				args);
		System.exit(exitCode);
	}

}
