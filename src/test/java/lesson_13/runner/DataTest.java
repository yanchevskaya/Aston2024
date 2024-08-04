package lesson_13.runner;

import java.util.List;

public class DataTest {

    static final String URL_SERVICE = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    static final List<String> LOGO_LIST_PAYMENT_MODULE = List.of("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");

    static final String NUMBER = "297777777";
    static final String PAYMENT = "100";

    static final List<String> LOGO_LIST_IFRAME = List.of(
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/maestro-system.svg",
            "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system-ru.svg");


    static final List<String> TITLE_FIELD = List.of(PAYMENT + ".00 BYN", "Оплата: Услуги связи Номер:375" + NUMBER,
            "Номер карты", "Срок действия", "Имя держателя (как на карте)", "CVC", "Оплатить " + PAYMENT + ".00 BYN");

}

