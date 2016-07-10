package net.riverSoft.model.visual;
/**
 * Модуль вывода сообщений
 */
public interface Visual {
	/**
	 * Сообщение приветствия
	 */
	public void WelcomeMessage();
	/**
	 * Сообщение номера договора
	 */
	public void ContractNumberMessage();
	/**
	 * Сообщение желаемой суммы кредита
	 */
	public void AmountLimitMessage();
	/**
	 * Сообщение желаемого срока кредитования
	 */
	public void LimitTerminationDateMessage();
	/**
	 * Сообщение ветвления для нового кредита или погашения существующего
	 */
	public void ActionMessage();
	/**
	 * Сообщение заголовка таблицы графика погашения
	 */
	public void ShowPaymentGridMessage();
	/**
	 * Сообщение схемы кредитования (ануитет/классика)
	 */
    public void creditRepaymentSchemeMessage();
	/**
	 * Сообщение суммы платежа по кредиту
	 */
    public void amountPaymentMessage();


}
