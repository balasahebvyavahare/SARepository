Sample Commands to Run Jars on Cloudera Quick Start VM.

hadoop jar DistributedCache.jar /user/cloudera/data/FileLoaderInput/File1 /user/cloudera/data/FileLoaderInput/out1/ /user/cloudera/data/FileLoaderInput/File2

hadoop jar DistributedCache1.jar /user/cloudera/data/DistributedCacheDemo/input/employees_tsv /user/cloudera/data/FileLoaderInput/out1/ /user/cloudera/data/DistributedCacheDemo/input/departments_txt

hadoop jar ReduceSideJoin.jar /user/cloudera/data/reduceSideJoin/input/part-e /user/cloudera/data/reduceSideJoin/input/part-sc /user/cloudera/data/reduceSideJoin/output /user/cloudera/data/reduceSideJoin/input/DEPARTMENTS
