import java.io.*;


class LowerCaseReader extends FilterReader {

    protected LowerCaseReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int ch = super.read();
        if (ch == -1) {
            return -1;
        }
        return Character.toLowerCase((char) ch);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int numChars = super.read(cbuf, off, len);
        if (numChars == -1) {
            return -1;
        }
        for (int i = off; i < off + numChars; i++) {
            cbuf[i] = Character.toLowerCase(cbuf[i]);
        }
        return numChars;
    }
}

public class UpperToLowerDecorator {
    public static void main(String[] args) {
        String inputString = "HELLO WORLD! THIS IS A TEST.";
        System.out.println("Original Input: " + inputString);

        try (Reader reader = new LowerCaseReader(new StringReader(inputString))) {
            int ch;
            System.out.print("Converted Output: ");
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
