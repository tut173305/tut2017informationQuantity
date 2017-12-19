package s4.b173305; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID.
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {     // このインタフェースは、周波数カウンタの設計を提供します。
    void setTarget(byte[]  target); // 検索するデータを設定します。
    void setSpace(byte[]  space);  // 検索対象となるデータを設定してください。
    int frequency(); //TARGETが設定されていないか、TARGETの長さがゼロの場合は-1を返します。
                    //それ以外の場合は、SPACEが設定されていないか、スペースの長さがゼロの場合は0を返します。
                    //さもなければ、スペースのTARGETの頻度を得なさい
    int subByteFrequency(int start, int end);
    // target [start]、target [start + 1]、...、target [end-1]のターゲットのサブバイトの頻度を取得します。
    // STARTまたはENDの値が正しくない場合の動作は未定義です。
}
*/

/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // 情報量を算出するためのデータを設定する
    void setSpace(byte space[]); // サンプル空間のデータをコンピュータ確率に設定する
    double estimation(); // ターゲットが設定されていないか、ターゲットの長さがゼロの場合は0.0を返します。
// true値が無限大の場合、または空白が設定されていない場合はDouble.MAX_VALUEを返します。
// true値がfineteでDouble.MAX_VALUEより大きい場合の動作は未定義です。
//これは、スペースが不当に大きい場合にのみ発生することに注意してください。 とにかく他の問題に遭遇します。
// そうでなければ、情報量の推定、
}
*/


public class TestCase {
    public static void main(String[] args) {
	try {
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("checking s4.b173305.Frequencer");
	    myObject = new s4.b173305.Frequencer();
	   // myObject.setSpace("Hi Ho Hi Ho".getBytes());
      myObject.setSpace("Hi Ho Hi Ho".getBytes());
	   // myObject.setTarget("H".getBytes());

      //テストとして文字列が"0"の場合を追加する
      myObject.setTarget("".getBytes());

	    freq = myObject.frequency();
      System.out.println(freq);

	    System.out.print("\"\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.b173305.InformationEstimator");
	    myObject = new s4.b173305.InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());
	    myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0 "+value);
	    myObject.setTarget("01".getBytes());
	    value = myObject.estimation();
	    System.out.println(">01 "+value);
	    myObject.setTarget("0123".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0123 "+value);
	    myObject.setTarget("00".getBytes());
	    value = myObject.estimation();
	    System.out.println(">00 "+value);
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

    }
}
