package com.onestep.hadoop.hiveUDF;

import java.io.IOException;
import org.apache.hadoop.hive.ql.exec.UDF;

public class NVL2 extends UDF {

	String expr1, expr2, expr3;
	
	public NVL2() {
	}
	
	public String evaluate(String pExpr1, String pExpr2, String pExpr3)
			throws IOException {

		try {

			expr1 = (String) pExpr1;
			expr2 = (String) pExpr2;
			expr3 = (String) pExpr3;

			return (expr1 != null ? expr2 : expr3);

		} catch (Exception e) {
			// Cause task failure
			throw new IOException("Error with Hive UDF, NVL2!", e);
		}
	}
}