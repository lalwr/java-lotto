package raffle.lotto.play;

import raffle.lotto.LottoMachine;
import raffle.lotto.money.Money;
import raffle.lotto.validator.LottoNumberValidator;
import raffle.lotto.win.LottoResult;
import raffle.view.InputView;
import raffle.view.ResultView;

public class PlayLotto {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        Money money = new Money(InputView.buyLotto() , InputView.lottoAmount());
        LottoMachine lottoMachine = new LottoMachine(money ,InputView.getLottoNumber(money.getManualCount()), new LottoNumberValidator());
        resultView.buyLotto(lottoMachine.getLottos(), money.getManualCount());

        LottoResult lottoResult = lottoMachine.winLotto(InputView.lastWeekLotto(), InputView.bonusLotto());
        resultView.result(lottoResult);

    }
}
