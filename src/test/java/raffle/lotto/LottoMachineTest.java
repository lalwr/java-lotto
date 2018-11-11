package raffle.lotto;

import org.junit.Before;
import org.junit.Test;
import raffle.lotto.money.Money;
import raffle.lotto.validator.LottoNumberValidator;
import raffle.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    LottoMachine lottoMachine;

    @Before
    public void setUp(){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 6, 5, 44, 22, 15)));

        Money money = new Money(3 , 13000);

        lottoMachine = new LottoMachine(money, lottos, new LottoNumberValidator());
    }

    @Test
    public void 로또입력확인() {
        assertThat(lottoMachine.getLottos()).hasSize(13);
    }

    @Test(expected = RuntimeException.class)
    public void 로또_수동_잘못된_숫자() {
        List<Lotto> notLottos = new ArrayList<>();
        notLottos.add(new Lotto(Arrays.asList(1, 6, 5, 44, 22, 77)));
        Money money = new Money(3 , 13000);

        lottoMachine = new LottoMachine(money, notLottos, new LottoNumberValidator());
    }

}