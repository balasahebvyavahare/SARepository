package advance.training.EnumClasses;

public enum EnumOlive {
		G("g") , T("t") , S("s") , H("h") , GOLDEN("goldan");
		
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
