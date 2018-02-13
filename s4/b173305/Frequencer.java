package s4.b173305; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID.
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {//このインタフェースは、周波数カウンタの設計を提供します。
void setTarget（byte [] target）; //検索するデータを設定します。
void setSpace（byte [] space）; //検索対象となるデータを設定します。
int frequency（）; // TARGETが設定されていないか、TARGETの長さがゼロの場合は-1を返します
//それ以外の場合は、SPACEが設定されていないか、スペースの長さがゼロの場合は0を返します。
//それ以外の場合は、SPACEのTAGETの頻度を取得します。
int subByteFrequency（int start、int end）;戻り値：
// tagetのsubByteの頻度、つまりtarget [start]、taget [start + 1]、...、target [end-1]を取得します。
// STARTまたはENDの値が正しくない場合の動作は未定義です。
*/

public class Frequencer implements FrequencerInterface{

  // Code to Test, *warning: This code  contains intentional problem*
  byte [] myTarget;
  byte [] mySpace;

  boolean targetReady = false;
  boolean spaceReady = false;
  int [] suffixArray;
  int [] a;

  // The variable, "suffixArray" is the sorted array of all suffixes of mySpace.
  // Each suffix is expressed by a interger, which is the starting position in mySpace.
  // The following is the code to print the variable
  private void printSuffixArray() {
    if(spaceReady) {
      for(int i=0; i< mySpace.length; i++) {
        int s = suffixArray[i];
        for(int j=s;j<mySpace.length;j++) {
          //System.out.write(mySpace[j]);
        }
        //System.out.write('\n');
      }
    }
  }

  private int suffixCompare(int i, int j) {
    // comparing two suffixes by dictionary order.
    // i and j denoetes suffix_i, and suffix_j
    // if suffix_i > suffix_j, it returns 1
    //////if(mySpace[i] > mySpace[j]){ return 1;}

    // if suffix_i < suffix_j, it returns -1
    //////if(mySpace[i] < mySpace[j]){ return -1;}

    // if suffix_i = suffix_j, it returns 0;
    //////if(mySpace[i] == mySpace[j]){ return 0;}

    // It is not implemented yet,
    // It should be used to create suffix array.
    // Example of dictionary order
    //Example of dictionary order
    // "i" < "o" : compare by code
    // "Hi" < "Ho" ; if head is same, compare the next element
    // "Ho"  < "Ho " ; if the prefix is identical, longer string is big
    //if the prefix is identical, longer string is big
    int si = suffixArray[i];
    int sj = suffixArray[j];
    int s = 0;
    if(si > s) s = si;
    if(sj > s) s = sj;
    int n = mySpace.length - s;
    for(int k=0;k<n;k++) {
      if(mySpace[si+k]>mySpace[sj+k]) return 1;
      if(mySpace[si+k]<mySpace[sj+k]) return -1;
    }
    if(si < sj) return 1;
    if(si > sj) return -1;
    return 0;
  }

  public void setSpace(byte []space) {
    mySpace = space;
    if(mySpace.length>0) spaceReady = true;
    suffixArray = new int[space.length];
    a = new int[space.length];


    // put all suffixes in suffixArray. Each suffix is expressed by one interger.
    //すべての接尾辞を接尾辞Arrayに入れます。 各接尾語は整数で表されます。
    for(int i = 0; i< space.length; i++) {
      suffixArray[i] = i;
      a[i] = i;
    }


    mergeSort(a);
    suffixArray = a;
    //バブルソート
    /*
    for(int i = 0 ; i  < mySpace.length-1; i++){
    for(int j = i+1; j < mySpace.length ; j++){

    //入れ替える
    if(suffixCompare(i,j) == 1){
    //int tmp = 0;
    int tmp = suffixArray[i];
    suffixArray[i] = suffixArray[j];
    suffixArray[j] = tmp;

  }
}
}
*/
// Sorting is not implmented yet.

/* Example from "Hi Ho Hi Ho"
0: Hi Ho
1: Ho
2: Ho Hi Ho
3:Hi Ho
4:Hi Ho Hi Ho
5:Ho
6:Ho Hi Ho
7:i Ho
8:i Ho Hi Ho
9:o
A:o Hi Ho
*/
//
printSuffixArray();
}

void mergeSort(int[] a){

  if(a.length > 1){
    int m = a.length/2;
    int n = a.length - m;
    int[] a1 = new int[m];
    int[] a2 = new int[n];
    for(int i = 0; i < m; i++){
      a1[i] = a[i];
    }

    for(int i = 0; i < n; i++){
      a2[i] = a[m+i];
    }

    mergeSort(a1);
    mergeSort(a2);

    merge(a1,a2,a);

  }
}

void merge(int[] a1, int[] a2, int[] a)
{
  int i = 0;
  int j = 0;

  while(i < a1.length || j < a2.length){
    if(j >= a2.length || (i < a1.length && (suffixCompare(a1[i],a2[j]) == -1)))
    {
      a[i+j] = a1[i];
      i++;
    }
    else{
      a[i+j] = a2[j];
      j++;
    }
  }
}

private int targetCompare(int i, int start, int end) {
  // comparing suffix_i and target_start_end by dictonary order with limitation of length;
  //suffix_iとtarget_start_endを辞書順で長さの制限付きで比較する
  int si = suffixArray[i];
  int se = end - start ;
  if(se > mySpace.length - si) return -1;
  int n = se;
  for(int k=0;k<n;k++) {
    if(mySpace[si+k]>myTarget[start+k]) return 1;
    if(mySpace[si+k]<myTarget[start+k]) return -1;
  }
  // if the beginning of suffix_i matches target_i_end, and suffix is longer than target it returns 0;
  //suffix_iの先頭がtarget_start_endと一致し、suffixがtargetよりも長い場合は0を返します。

  // if suffix_i > target_start_end it return 1;
  // if suffix_i < target_start_end it return -1
  // It is not implemented yet.
  // It should be used to search the apropriate index of some suffix.
  // Example of search
  // suffix    target
  // "o"    > "i"
  // "o"   < "z"
  // "o"  = "o"
  // "o"  < "oo"
  // "Ho" > "Hi"
  // "Ho" < "Hz"
  // "Ho" = "Ho"
  //"Ho" < "Ho" :"Ho"isnotintheheadofsuffix"Ho"
  // "Ho" = "H" : "H" is in the head of suffix "Ho"
  return 0;
}

private int subByteStartIndex(int start, int end) {
  // It returns the index of the first suffix which is equal or greater than subBytes;
  //これは、subBytes以上の最初の接尾辞のインデックスを返します
  // not implemented yet;
  // For "Ho", it will return 5 for "Hi Ho Hi Ho".
  // For "Ho ", it will return 6 for "Hi Ho Hi Ho".
  for(int i = 0; i < mySpace.length; i++){
    if(targetCompare(i,start,end) == 0){
      return i;
    }
  }
  return suffixArray.length;
}

private int subByteEndIndex(int start, int end) {
  // It returns the next index of the first suffix which is greater than subBytes;
  //これは、subBytesより大きい最初の接尾辞の次のインデックスを返します
  // not implemented yet
  // For "Ho", it will return 7 for "Hi Ho Hi Ho".
  // For "Ho ", it will return 7 for "Hi Ho Hi Ho".
  for(int i = 0; i < mySpace.length - 1; i++){
    if(targetCompare(i,start,end) == 0 && targetCompare(i+1,start,end) != 0){
      return i+1;
    }
  }
  return suffixArray.length;
}

public int subByteFrequency(int start, int end) {
  //This method could be defined as follows though it is slow.
  int spaceLength = mySpace.length;
  int count = 0;
  for(int offset = 0; offset< spaceLength - (end - start); offset++) {
    boolean abort = false;
    for(int i = 0; i< (end - start); i++) {
      if(myTarget[start+i] != mySpace[offset+i]) { abort = true; break; }
    }
    if(abort == false) { count++; }
  }

  int first = subByteStartIndex(start,end);
  int last1 = subByteEndIndex(start, end);


  // inspection code
  for(int k=start;k<end;k++) {
    //System.out.write(myTarget[k]);
  }
  //System.out.printf(": first=%d last1=%d\n", first, last1);

  return last1 - first;
}

public void setTarget(byte [] target) {
  myTarget = target; if(myTarget.length>0) targetReady = true;
}

public int frequency() {
  if(targetReady == false) return -1;
  if(spaceReady == false) return 0;
  return subByteFrequency(0, myTarget.length);
}

public static void main(String[] args) {
  Frequencer frequencerObject;
  try {
    frequencerObject = new Frequencer();

    frequencerObject.setSpace("Hi Ho Hi Ho".getBytes());
    frequencerObject.setTarget(" ".getBytes());
    int result = frequencerObject.frequency();
    System.out.print("Freq = "+ result+" ");
    if(1 == result) { System.out.println("OK"); }
    else {System.out.println("WRONG"); }
  }
  catch(Exception e) {
    System.out.println("STOP"); }
  }
}
