public class Account {

    private String accountNumber;

    public Account(String accountNumber) {
       setAccountNumber(accountNumber);
    }

    public void setAccountNumber(String accountNumber) {

        if (!accountNumber.matches("\\d{3}-\\d{7}-\\d{2}")) {
            throw new IllegalArgumentException("Error - Invalid pattern!");
        }

        int sum = 0;

        for (int i = 0; i < 11; i++) {
            if (Character.isDigit(accountNumber.charAt(i))) {
                sum += Character.getNumericValue(accountNumber.charAt(i));
            }
        }

        int remainder = sum % 97;

        int last2Numbers = Integer.parseInt(accountNumber.substring(12, 14));


        if (remainder != last2Numbers) {
            throw new IllegalArgumentException("Error - Invalid number!");
        }

        this.accountNumber = accountNumber;
    }
}
