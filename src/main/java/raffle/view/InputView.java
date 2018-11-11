package raffle.view;

import raffle.lotto.Lotto;
import raffle.lotto.LottoNo;
import raffle.lotto.win.LottosCreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int lottoAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        int lottoAmount = sc.nextInt();
        return lottoAmount;
    }

    public static Lotto lastWeekLotto(){
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return new Lotto(Arrays.stream(sc.nextLine().split(", ")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public static LottoNo bonusLotto(){
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return new LottoNo(sc.nextInt());
    }

    public static int buyLotto() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        int bonusLottoCount = sc.nextInt();
        return bonusLottoCount;
    }

    public static List<Lotto> getLottoNumber(int lottoCount) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Arrays.stream(sc.nextLine().split(", ")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList())));
        }
        return lottos;

    }

}
