package rle;

public class RunlengthEncoding {
    public static void main(String[] args) {
        testEncoding();
        System.out.println("-----------------------------------");
        testDecoding();
    }

    /*
     * Hàm mã hóa chuỗi ký tự text theo mã hóa run-length.
     * Ví dụ: "aaabbc" -> "a3b2c1"
     */
    public static String encoding(String text) {
        if (text == null || text.isEmpty()) return "";

        StringBuilder encoded = new StringBuilder();
        int count = 1;

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == text.charAt(i - 1)) {
                count++;
            } else {
                encoded.append(text.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        encoded.append(text.charAt(text.length() - 1)).append(count);

        return encoded.toString();
    }

    /*
     * Hàm giải mã chuỗi ký tự text theo mã hóa run-length.
     * Ví dụ: "a3b2c1" -> "aaabbc"
     */
    public static String decoding(String text) {
        if (text == null || text.isEmpty()) return "";

        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            StringBuilder countStr = new StringBuilder();

            // Đọc số (có thể gồm nhiều chữ số)
            while (i + 1 < text.length() && Character.isDigit(text.charAt(i + 1))) {
                i++;
                countStr.append(text.charAt(i));
            }

            int count = Integer.parseInt(countStr.toString());
            decoded.append(String.valueOf(ch).repeat(count));
        }

        return decoded.toString();
    }

    /*
     * Hàm test mã hóa theo mã hóa run-length.
     */
    public static void testEncoding() {
        String decodedText = "aaabbbccccdde";
        String encodedText = encoding(decodedText);
        System.out.println("Decoded Text: " + decodedText);
        System.out.println("Encoded Text: " + encodedText);
        System.out.println();
    }

    /*
     * Hàm test giải mã theo mã hóa run-length.
     */
    public static void testDecoding() {
        String encodedText = "a3b3c4d2e1";
        String decodedText = decoding(encodedText);
        System.out.println("Encoded Text: " + encodedText);
        System.out.println("Decoded Text: " + decodedText);
        System.out.println();
    }
}


