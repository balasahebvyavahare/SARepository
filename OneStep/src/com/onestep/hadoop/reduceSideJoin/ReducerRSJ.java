package com.onestep.hadoop.reduceSideJoin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.MapFile;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.log4j.Logger;

public class ReducerRSJ extends
		Reducer<CompositeKeyWritableRSJ, Text, Text, Text> {

	private static final Logger LOG = Logger.getLogger(ReducerRSJ.class);

	StringBuilder reduceValueBuilder = new StringBuilder("");
	NullWritable nullWritableKey = NullWritable.get();
	Text reduceOutputValue = new Text("");
	String strSeparator = ",";
	private MapFile.Reader deptMapReader = null;
	Text txtMapFileLookupKey = new Text("");
	Text txtMapFileLookupValue = new Text("");
	private BufferedReader brReader;
	private static HashMap<String, String> DepartmentMap = new HashMap<String, String>();

	@Override
	protected void setup(Context context) throws IOException,
			InterruptedException {
		Path[] cacheFilesLocal = DistributedCache.getLocalCacheFiles(context
				.getConfiguration());

		LOG.info("Tesing , fuck " + cacheFilesLocal[0]);

		for (Path eachPath : cacheFilesLocal) {
			if (eachPath.getName().toString().trim().equals("DEPARTMENTS")) {
				LOG.info("Tesing , fuck " + "Found the cache file");
				loadDepartmentsHashMap(eachPath, context);
			}
		}
	}

	private void loadDepartmentsHashMap(Path filePath, Context context)
			throws IOException {

		String strLineRead = "";

		try {
			brReader = new BufferedReader(new FileReader(filePath.toString()));

			// Read each line, split and load to HashMap
			while ((strLineRead = brReader.readLine()) != null) {
				String deptFieldArray[] = strLineRead.split("\\|");

				LOG.info("fuck mapreduce " + deptFieldArray[0].trim()
						+ deptFieldArray[1].trim());

				DepartmentMap.put(deptFieldArray[0].trim(),
						deptFieldArray[1].trim());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (brReader != null)
				brReader.close();

		}
	}

	private StringBuilder buildOutputValue(CompositeKeyWritableRSJ key,
			StringBuilder reduceValueBuilder, Text value) {

		if (key.getsourceIndex() == 1) {
			
			reduceValueBuilder.append(key.getjoinKey()).append(',');
			
			String arrEmpAttributes[] = value.toString().split(",");
			
			String DCkey = arrEmpAttributes[3].toString();
			
			String DCValue = DepartmentMap.get(DCkey);
			
			reduceValueBuilder.append(value.toString()).append(',').append(DCValue).append(',');
			
			
			LOG.info("I am if inside reduceValueBuilder" + key.getjoinKey());
			LOG.info("I am if inside reduceValueBuilder" + key.getsourceIndex());
			
			LOG.info("I am if inside reduceValueBuilder" + value.toString());
			
			
		} else {

			reduceValueBuilder.append(value.toString()).append(',');
			LOG.info("I am else inside reduceValueBuilder" + key.getjoinKey());
			LOG.info("I am else inside reduceValueBuilder" + key.getsourceIndex());
			
			LOG.info("I am if inside reduceValueBuilder" + value.toString());
		}
		
		return reduceValueBuilder;
	}

	@Override
	public void reduce(CompositeKeyWritableRSJ key, Iterable<Text> values,
			Context context) throws IOException, InterruptedException {

		for (Text value : values) {
			buildOutputValue(key, reduceValueBuilder, value);
		}
		
		context.write(new Text("abc"), new Text(reduceValueBuilder.toString()));
	}

}
