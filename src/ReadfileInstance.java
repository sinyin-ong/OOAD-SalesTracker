import java.io.File;  
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadfileInstance {
  private String fileName;
  private Scanner inputFile;
  public List<Object> datas = new ArrayList<Object>();
  private int numOfData; 

  public ReadfileInstance(String fileName) {
    try {
      int line_counter = 0;
      char delimiter = '|';
      this.fileName = fileName;
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      inputFile = myReader;
      while (myReader.hasNextLine()) {
        int col_counter = 0;
        Object[] tempObj = new Object[10];
        String data = myReader.nextLine();

        while (data.indexOf(delimiter) >= 0) {
          String temp = data.substring(0, data.indexOf(delimiter)).trim();
          tempObj[col_counter] = temp;
          data = data.substring(data.indexOf(delimiter) + 1);

          col_counter++;
        } 

        datas.add(tempObj);
        line_counter++;
      }

      numOfData = line_counter;
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return "ReadfileInstance{" +
            "fileName='" + fileName + '\'' +
            ", inputFile=" + inputFile +
            ", datas=" + datas +
            ", numOfData=" + numOfData +
            '}';
  }
  
  // getters
  public String getFileName() {
    return "File Name: " + fileName;
  }
  public Scanner getInputFile() {
    return inputFile;
  }
  public Object[][] getData() {
    return datas.toArray(new Object[datas.size()][3]);
  }
  public String getNumOfData() {
    return "Number of datas: " + numOfData;
  }
}