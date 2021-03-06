import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.*;

/** Converts a given excel file to an arraylist of item objects. */
public class ExcelFileToArrayList {
    public static ArrayList<Item> convert(String fileNameOfExcelFile) throws IOException, URISyntaxException {
        ArrayList<Item> temp = new ArrayList<>();

        String excelFilePath = "/Resources/" + fileNameOfExcelFile;
        
        URL resource = ExcelFileToArrayList.class.getResource(excelFilePath);
        
        File file = new File(resource.toURI());

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        String topic = null;
        String question = null;
        String choiceOne = null;
        String choiceTwo = null;
        String choiceThree = null;
        String choiceFour = null;
        String correctChoice = null;
        String questionImageFilename = null;
        String choiceAImageFilename = null;
        String choiceBImageFilename = null;
        String choiceCImageFilename = null;
        String choiceDImageFilename = null;
        String category = null;
        

        for (int r = 1; r <= rows; r++) {
            XSSFRow tempRow = sheet.getRow(r);

            for (int c = 1; c <= cols; c++) {
                XSSFCell cell = tempRow.getCell(c);

                switch (c) {
                    case 1:
                        topic = cell.toString();
                        break;
                    case 2:
                        question = cell.toString();
                        break;
                    case 3:
                        choiceOne = cell.toString();
                        break;
                    case 4:
                        choiceTwo = cell.toString();
                        break;
                    case 5:
                        choiceThree = cell.toString();
                        break;
                    case 6:
                        choiceFour = cell.toString();
                        break;
                    case 7:
                        correctChoice = cell.toString();
                        break;
                    case 8:
                        if (cell == null) {
                            questionImageFilename = "";
                        } else {
                            questionImageFilename = cell.toString();
                        }
                        break;
                    case 9:
                        if (cell == null) {
                            choiceAImageFilename = "";
                        } else {
                            choiceAImageFilename = cell.toString();
                        }
                        break;
                    case 10:
                        if (cell == null) {
                            choiceBImageFilename = "";
                        } else {
                            choiceBImageFilename = cell.toString();
                        }
                        break;
                    case 11:
                        if (cell == null) {
                            choiceCImageFilename = "";
                        } else {
                            choiceCImageFilename = cell.toString();
                        }
                        break;
                    case 12:
                        if (cell == null) {
                            choiceDImageFilename = "";
                        } else {
                            choiceDImageFilename = cell.toString();
                        }
                        break;
                    case 13:
                        category = cell.toString();
                        break;
                }
            }
            temp.add(new Item(topic, question, choiceOne, choiceTwo, choiceThree, choiceFour, correctChoice, questionImageFilename,
                    choiceAImageFilename, choiceBImageFilename, choiceCImageFilename, choiceDImageFilename, category));
        }

        return temp;
    }
}
