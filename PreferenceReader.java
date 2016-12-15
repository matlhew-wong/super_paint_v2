import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileWriter;
import java.io.FileNotFoundException;

import java.awt.Color;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;

/**
 * Preference Reader Class
 * Description: This class reads and sets the preference files
 *              
 * 
 * May 30 2016
 * @author Matthew Wong
 * @version 1.0
 * 
 */

public class PreferenceReader {
    
    String preferences;
    String line;
    
    File shapeType;
    File fill;
    File grad;
    File firstColor;
    File secondColor;
    File lineWidth;
    File dashWidth;
    File dash;
    
        

    public PreferenceReader() {
        shapeType = new File("preference/shapeType");
        if (shapeType.exists()) {
            try {
                FileReader fileReader = new FileReader(shapeType);
            } catch(FileNotFoundException e) {
            }
        } else {
            try {
                FileWriter writer = new FileWriter(shapeType);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("1");
                bufferedWriter.close(); 
            } catch(IOException e) {
            }
        }
        fill = new File("preference/fill");
        if (fill.exists()) {
            try {
                FileReader fileReader = new FileReader(fill);
            } catch(FileNotFoundException e) {
            }
        } else {
            try {
                FileWriter writer = new FileWriter(fill);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("false");
                bufferedWriter.close(); 
            } catch(IOException e) {
            }
        }
        grad = new File("preference/grad");
        if (grad.exists()) {
            try {
                FileReader fileReader = new FileReader(grad);
            } catch(FileNotFoundException e) {
            }
        } else {
            try {
                FileWriter writer = new FileWriter(grad);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("false");
                bufferedWriter.close(); 
            } catch(IOException e) {
            }
        }
        firstColor = new File("preference/firstColor");
        if (firstColor.exists()) {
            try {
                FileReader fileReader = new FileReader(firstColor);
            } catch(FileNotFoundException e) {
            }
        } else {
            try {
                FileWriter writer = new FileWriter(firstColor);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("1");
                bufferedWriter.close(); 
            } catch(IOException e) {
            }
        }
        secondColor = new File("preference/secondColor");
        if (secondColor.exists()) {
            try {
                FileReader fileReader = new FileReader(secondColor);
            } catch(FileNotFoundException e) {
            }
        } else {
            try {
                FileWriter writer = new FileWriter(secondColor);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("1");
                bufferedWriter.close(); 
            } catch(IOException e) {
            }
        }
        lineWidth = new File("preference/lineWidth");
        if (lineWidth.exists()) {
            try {
                FileReader fileReader = new FileReader(lineWidth);
            } catch(FileNotFoundException e) {
            }
        } else {
            try {
                FileWriter writer = new FileWriter(lineWidth);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("1");
                bufferedWriter.close(); 
            } catch(IOException e) {
            }
        }
        dashWidth = new File("preference/dashWidth");
        if (dashWidth.exists()) {
            try {
                FileReader fileReader = new FileReader(dashWidth);
            } catch(FileNotFoundException e) {
            }
        } else {
            try {
                FileWriter writer = new FileWriter(dashWidth);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("1");
                bufferedWriter.close(); 
            } catch(IOException e) {
            }
        }
        dash = new File("preference/dash");
        if (dash.exists()) {
            try {
                FileReader fileReader = new FileReader(dash);
            } catch(FileNotFoundException e) {
            }
        } else {
            try {
                FileWriter writer = new FileWriter(dash);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("1");
                bufferedWriter.close(); 
            } catch(IOException e) {
            }
        }
    }
    
    public String returnShapeType() {
        String shapeTypeString;
        try {
            FileReader fileReader = new FileReader(shapeType);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            shapeTypeString = bufferedReader.readLine();
            bufferedReader.close(); 
        } catch(IOException e) {
            shapeTypeString = "1";
        }
        return shapeTypeString;
    }
    
    public void setShapeType(int shapeTypeInt) {
        try {
            FileWriter writer = new FileWriter(shapeType);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(Integer.toString(shapeTypeInt));
            bufferedWriter.close(); 
        } catch(IOException e) {
        }
    }
        
    public String returnFill() {
        String fillString;
        try {
            FileReader fileReader = new FileReader(fill);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            fillString = bufferedReader.readLine();
            bufferedReader.close(); 
        } catch(IOException e) {
            fillString = "false";
        }
        return fillString;
    }
    
    public void setFill(boolean fillBool) {
        try {
            FileWriter writer = new FileWriter(fill);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(Boolean.toString(fillBool));
            bufferedWriter.close(); 
        } catch(IOException e) {
        }
    }
    
    public String returnGrad() {
        String gradString;
        try {
            FileReader reader = new FileReader(grad);
            BufferedReader bufferedReader = new BufferedReader(reader);
            gradString = bufferedReader.readLine();
            bufferedReader.close(); 
        } catch(IOException e) {
            gradString = "false";
        }
        return gradString;
    }
    
    public void setGrad(boolean gradBool) {
        try {
            FileWriter writer = new FileWriter(grad);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(Boolean.toString(gradBool));
            bufferedWriter.close(); 
        } catch(IOException e) {
        }
    }
    
    public String returnFirstColor() {
        String firstColorString;
        try {
            FileReader reader = new FileReader(firstColor);
            BufferedReader bufferedReader = new BufferedReader(reader);
            firstColorString = bufferedReader.readLine();
            bufferedReader.close(); 
        } catch(IOException e) {
            firstColorString = "1";
        }
        return firstColorString;
    }
    
    public void setFirstColor(int color) {
        try {
            FileWriter writer = new FileWriter(firstColor);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(Integer.toString(color));
            bufferedWriter.close(); 
        } catch(IOException e) {
        }
    }
    
    public String returnSecondColor() {
        String secondColorString;
        try {
            FileReader reader = new FileReader(secondColor);
            BufferedReader bufferedReader = new BufferedReader(reader);
            secondColorString = bufferedReader.readLine();
            bufferedReader.close(); 
        } catch(IOException e) {
            secondColorString = "1";
        }
        return secondColorString;
    }
    
    public void setSecondColor(int color) {
        try {
            FileWriter writer = new FileWriter(secondColor);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(Integer.toString(color));
            bufferedWriter.close(); 
        } catch(IOException e) {
        }
    }
    
    public String returnLineWidth() {
        String lineWidthString;
        try {
            FileReader reader = new FileReader(lineWidth);
            BufferedReader bufferedReader = new BufferedReader(reader);
            lineWidthString = bufferedReader.readLine();
            bufferedReader.close(); 
        } catch(IOException e) {
            lineWidthString = "1";
        }
        return lineWidthString;
    }
    
    public void setLineWidth(int width) {
        try {
            FileWriter writer = new FileWriter(lineWidth);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(Integer.toString(width));
            bufferedWriter.close(); 
        } catch(IOException e) {
        }
    }
    
    public String returnDashWidth() {
        String dashWidthString;
        try {
            FileReader reader = new FileReader(dashWidth);
            BufferedReader bufferedReader = new BufferedReader(reader);
            dashWidthString = bufferedReader.readLine();
            bufferedReader.close(); 
        } catch(IOException e) {
            dashWidthString = "1";
        }
        return dashWidthString;
    }
    
    public void setDashWidth(int width) {
        try {
            FileWriter writer = new FileWriter(dashWidth);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(Integer.toString(width));
            bufferedWriter.close(); 
        } catch(IOException e) {
        }
    }
    
    public String returnDash() {
        String dashString;
        try {
            FileReader reader = new FileReader(dash);
            BufferedReader bufferedReader = new BufferedReader(reader);
            dashString = bufferedReader.readLine();
            bufferedReader.close(); 
        } catch(IOException e) {
            dashString = "1";
        }
        return dashString;
    }
    
    public void setDash(boolean dashBool) {
        try {
            FileWriter writer = new FileWriter(dash);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(Boolean.toString(dashBool));
            bufferedWriter.close(); 
        } catch(IOException e) {
        }
    }
    
}
    
    
