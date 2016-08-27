package com.onestep.hadoop.mapsidejoinwithdistributedcache;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;



public class MapperMapSideJoinDCacheTextFile extends
		Mapper<LongWritable, Text, Text, Text> {

	private static HashMap<String, String> DepartmentMap = new HashMap<String, String>();
	private BufferedReader brReader;
	private String strDeptName = "";
	private Text txtMapOutputKey = new Text("");
	private Text txtMapOutputValue = new Text("");

	private static final Logger LOG = Logger.getLogger(MapperMapSideJoinDCacheTextFile.class);
	
	enum MYCOUNTER {
		RECORD_COUNT, FILE_EXISTS, FILE_NOT_FOUND, SOME_OTHER_ERROR
	}

	@Override
	protected void setup(Context context) throws IOException,
			InterruptedException {
		Path[] cacheFilesLocal = DistributedCache.getLocalCacheFiles(context
				.getConfiguration());
		System.out.println("distributed cache path : " + cacheFilesLocal[0]);
		
		LOG.info("Tesing , fuck ");
		
		
		
		for (Path eachPath : cacheFilesLocal) {
			if (eachPath.getName().toString().trim().equals("departments_txt")) {
				context.getCounter(MYCOUNTER.FILE_EXISTS).increment(1);
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
				DepartmentMap.put(deptFieldArray[0].trim(),
						deptFieldArray[1].trim());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			context.getCounter(MYCOUNTER.FILE_NOT_FOUND).increment(1);
		} catch (IOException e) {
			context.getCounter(MYCOUNTER.SOME_OTHER_ERROR).increment(1);
			e.printStackTrace();
		} finally {
			if (brReader != null) {
				brReader.close();

			}

		}
	}

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		context.getCounter(MYCOUNTER.RECORD_COUNT).increment(1);

		if (value.toString().length() > 0) {
			String arrEmpAttributes[] = value.toString().split("\\|");

			try {
				strDeptName = DepartmentMap.get(arrEmpAttributes[6].toString());
			} finally {
				strDeptName = ((strDeptName.equals(null) || strDeptName
						.equals("")) ? "NOT-FOUND" : strDeptName);
			}

			//txtMapOutputKey.set(arrEmpAttributes[0].toString());
			
			txtMapOutputValue.set(arrEmpAttributes[0].toString());

			txtMapOutputValue.set(arrEmpAttributes[1].toString() + "|"
					+ arrEmpAttributes[1].toString() + "|"
					+ arrEmpAttributes[2].toString() + "|"
					+ arrEmpAttributes[3].toString() + "|"
					+ arrEmpAttributes[4].toString() + "|"
					+ arrEmpAttributes[5].toString() + "|"
					+ arrEmpAttributes[6].toString() + "|" + strDeptName);

		}
		context.write(txtMapOutputKey, txtMapOutputValue);
		strDeptName = "";
	}

}
