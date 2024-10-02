package homework.homework5;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class Thief {
    private BigDecimal money;

    private Thief() {
        this.money = BigDecimal.ZERO;
    }

    private void stealMoney(Bank bank) throws NoSuchFieldException, IllegalAccessException {
        Class<Bank> bankClass = Bank.class;
        Field moneyBank = bankClass.getDeclaredField("money");
        moneyBank.setAccessible(true);
        BigDecimal currentBank = (BigDecimal) moneyBank.get(bank);
        money = money.add(currentBank);
        moneyBank.set(bank, BigDecimal.ZERO);
    }

    @Override
    public String toString() {
        return "Thief{" +
                "money=" + money +
                '}';
    }
}
