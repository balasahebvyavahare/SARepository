package j_completereference;

public class validIdentifier{
int _$;
int $7;
int do;
 public static void main(String argv[]){


	 validIdentifier test = new validIdentifier();
 test.$7=7;
 test.do=9;

 System.out.println(test.$7);
 System.out.println(test.do);
 System.out.println(test._$);

 }
}

/*$7 is valid identifier. Identifiers must start with a letter, a currency character ($), or
underscore ( _ ). Identifiers cannot start with a number. You can't use a Java keyword as
an identifier. do is a Java keyword. */