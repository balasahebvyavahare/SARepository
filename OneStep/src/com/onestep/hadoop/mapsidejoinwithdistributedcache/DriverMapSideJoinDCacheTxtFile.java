package com.onestep.hadoop.mapsidejoinwithdistributedcache;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class DriverMapSideJoinDCacheTxtFile extends Configured implements Tool {

  @Override
	public int run(String[] args) throws Exception {

	  Path outputPath = new Path(args[1]);
	  
		if (args.length != 3) {
			System.out
					.printf("Two parameters are required- <input dir> <output dir>\n");
			return -1;
		}

		System.out.println("Version 1.4");

		Configuration conf = getConf();
		
		DistributedCache.addCacheFile(new Path(args[2]).toUri(), conf);
		
		Job job = Job.getInstance(conf);
		job.setJobName("Map-side join with text lookup file in DCache");
		job.setJarByClass(DriverMapSideJoinDCacheTxtFile.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job,outputPath);
		job.setMapperClass(MapperMapSideJoinDCacheTextFile.class);

		job.setNumReduceTasks(0);
		
		FileSystem fs = FileSystem.newInstance(getConf());

		if (fs.exists(outputPath)) {
			fs.delete(outputPath, true);
		}

		boolean success = job.waitForCompletion(true);
		return success ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new Configuration(),
				new DriverMapSideJoinDCacheTxtFile(), args);
		System.exit(exitCode);
	}
}