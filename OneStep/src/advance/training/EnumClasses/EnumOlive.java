package advance.training.EnumClasses;

public enum EnumOlive {
		GU("gu") , TATTI("tatti") , SANDAS("sandas") , HUGAN("hugan") , GOLDEN("goldan");
		
		private String nameAsString;
		
		private EnumOlive(String str) {
			this.nameAsString = str;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.nameAsString;
		}
}
