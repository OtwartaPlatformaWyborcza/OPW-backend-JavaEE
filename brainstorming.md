# Burza mózgów
W naszej Burzy mózgów [Wiki](http://pl.wikipedia.org/wiki/Burza_m%C3%B3zg%C3%B3w) zbieramy pomysły na przyszłość. 

1. (Przemek) Na wydruku protokołu wyborów dołożyc QR Code z zawartą informacją dotyczącą liczb z tego konkretnego protokołu. Zeskanowanie QR codu pozwala na natychmiastowe otrzymanie wyniku obliczeń Komisji Wyborczej oraz graficznego obrazu protokołu.
2. (Przemek) Archiwizacja wyników. 


### Wersja rozszeżona
1. Sprawdzenie certyfikatów i uwierzytelnień operatorów i przewodniczących - funcja docelowa w przyszłości
2. Import Danych do serwera (protokołów)
3. Potwierdzenie otrzymania danych dla użytkownika (np wysłanie maila)
4. Panel administracyjny dla Administratora jakie dane z których komisji spłyneły wraz z warningami (selecty SQL + maski w paper browser ) 


**Przygotowanie wyborów ( funkcjonalnoć docelowa )**

1. Administrator definiuje/ importuje koordynatorów wyborów (imie, nazwisko, telefon, mail, przypisane komisje obwodowe najczęsciej gminne bądź dzielnicowe)
2. Administrator zakłada konta koordynatorom i łączy je z odpowiednimi komisjami i obwodami
3. Kordynator wybórów zakłada konta operatorom i przewodniczącemu komisji - Import XLS
4. Administrator generuje i rozsyła certyfikaty SSL/TSL koordynatorom
5. Koordynator wyborów definiuje/importuje składy komisji lokalnych i przypisuje do nr komisji
6. System generuje hasła dostepu dla operatorow i przewodniczących komisji, którzy proszą po zalogowaniu się o wydanie certyfikatu 


1.  ***System po zatwierdzeniu zgłoszenia przez Administratora udostepnia certyfikat do pobrania operatorom i przewodniczacym -  funkcja docelowa w przyszłośći***
4.  Użytkownik ma możliwość wydrukowania protokołu (nie wypełnionego także)
5.  Użytkownik ma możliwość zapisania/wczytania protokołu na/z zewnetrznego nośnika (CD, USB)
8. Użytkownik otrzymuje powiadomienie o odebraniu protokołu przez serwer np po przez mail
9.  ***Raport błedów/ostrzeżeń dla przewodniczacych komisji - funkcja docelowa w przyszlości.***

## Risk & Issue Logs
1. Wysyłanie protokołów i zakonczenie liczenia głosów w 25000 komisjach zazwyczaj konczy się o tej samej porze +/- 15 min w przypadku prostych wyborów jakimi są Wybory Prezydenckie Potrzebna Analiza wydajnosciowa serwerów  w tym (SQL, Moc Obliczeniowa maszyny oraz sama przepustowość łącza i-net). Zastanowić się nad modułem synchronizacji otrzymywania wyników.

2. Goście (wyborcy), którzy będą chcieli sprawdzić niezależne wyniki na stronie www - mogą spowodować zawieszenie się wydajnościowe serwera, gdy usługa będzie cieszyć sie bardzo dużą popularnoscią. Do rozważenia wprowadzenie modułu logowania na gości i ograniczenie ilości połaczeń dla danego gościa.   

## Appendix Features
1. Moduł generowania umów zleceń z operatorami oraz wypaty diet dla członków komisji wraz z wstępnie wypełnionym PIT-R
2. Import / eksport danych operatorów i członków komisji z/do pliku XLS 
3. Moduł "Przypominajek" dla operatorów i członków komisji wyborczych mowiący o poprawnym przeprowadzeniu procedury wyborów np. Wywieszeniu Obwieszczeń, Wydrukowaniu w należytej ilosci kopii protokołów, Zabezpieczeniu Brudnopisów, Zgraniu na zewnętrzny nośnik elektronicznej wersji protokołu, Przekazanie protokołu fizcznie po wydrukowaniu do KBW itp itd etc.   



## Wariant rozszeżony
 

### Administrator 

 *  OPW-A-10 : Jako administrator po poprawnym zalogowaniu się do systemu otrzymuje możliwość generowania haseł dla Koordynatórów Gminnych, Operatorów i Przewodniczących oraz ich usuwania bądz reedytowania  
 * OPW-A-11 : Jako administrator definiuję/ importuję koordynatorów gminnych (imię, nazwisko, telefon, mail, przypisane obwody najcześciej gmina bądź dzielnica ) - Import do/z 
XLS  
 *  OPW-A-12 : Jako administrator zakładam konta użytkownikom  i łączę je z odpowiednimi komisjami
 *  OPW-A-13 : Jako administrator zakładam konta koordynatorom gminy i łączę je z odpowiednimi gminami/zestawami komisji  
 *  OPW-A-14 : Jako administrator zatwierdzam requesty certyfikatów imiennych dla przewodniczących i operatorów informatycznych
 *    OPW-A-15 : Jako administrator wysyłam hasła użytkownikom
 *    OPW-A-16 : Jako administrator wysyłam hasła koordynatorom
 *    OPW-A-17 : Jako administrator wprowadzam kandydatów i mam możliwość ich edycji  
 *    OPW-A-18 : Jako administrator mam narzędzie do weryfikacji spływajacych danych (protokołów z konkretnych komisji wraz z warningami) 




### Koordynator Gminy  (rola docelowa jeśli będziemy integrować się z PKW)
* OPW-K-1 : Jako koordynator wprowadzam, zatwierdzam i edytuję składy komisji lokalnych dostarczonych przez operatorów importując dane z / do XLS  oraz  do/z systemu (Imię, Nazwisko, Pesel, mail, telefon, funkcja członka komisji)
* OPW-K-2 : Jako koordynator wprowadzam nadmiarową ilość członków komisji dla danej komisji  i mam możliwość w przeddzień wyborów zatwierdzić ostateczny skład komisji
* OPW-K-3 : Jako koordynator mam dostęp do części systemu, który waliduje członków komisji i ich poprawność przed ostatecznym zaakceptowaniem składu komisji (walidacja po PESEL, zameldowaniu, czy występuje dany członek komisji tylko w jednej komisji)
* OPW-K-4 : Jako koordynator najlepiej jakbym miał dostęp w systemie do bramki sms-owej przez którą mógłbym wysyłać informacje operatorom pracującym dla mnie
* OPW-K-5 : Jako koordynator mam dostęp do wygenerowanych haseł przed administratora dla operatorów i użytkowników
* OPW-K-6 : Jako koordynator dystrybuuję otrzymane od KBW certyfikaty dla Przewodiczących komisji


### Operator (rola docelowa jeśli będziemy integrować się z PKW)
* OPW-O-0 : Jako operator zbieram informacje od/i o członkach komisji (imię, nazwisko, nr komisji,  delegujący Komitet Wyborczy, data powołania, PESEL członków, Czy nie kandydują w wyborach )
* OPW-O-1 : Jako operator uzyskane dane o członkach komisji jestem w stanie zaimportować z pliku XLS do systemu
* OPW-O-2 : Jako operator mam dostęp do haseł użytkownków
* OPW-O-3 : Jako operator wpisuję  i uzupełniam protokół
* OPW-O-4 : Jako operator mam dostęp do formularza protokołu, który uzupełniany jest automatycznie o podstawowe dane takie jak: data, godzina protokołu, adres komisji, numer komisji
* OPW-O-5 : Jako operator mam możliwość wydrukowania pustego i wypełnionego formularza protokołu
* OPW-O-6 : Jako operator przy wpisywaniu formularza protokołu - formularz zostaje walidowany ( do wyspecyfikowania ) Twarde i Miękkie błedy od razu
*  OPW-O-7 : Jako operator przedstawiam wypełniony protokół do podpisania i uwierzytelnienia dla przewodniczącego komisji (użytkownika)
* OPW-O-8 : Jako operator wysyłam podpisany i uwierzytelniony protokół i otrzymuję raport błędów protokołu  (przetworzonego przez serwer)
* OPW-O-9 : Jako operator mam możliwość poprawiania protokołu wraz z wyjaśnieniem poprawki i naniesieniem nowej wersji protokołu
* OPW-O-10 : Jako Operator mam możliwość "zgrania" protokołu na nosnik CD bądź pendrive i przekazuję go w postaci fizycznej do koordynatora
* OPW-O-11 : Jako operator otrzymuję komunikat i potwierdzenie wysłania i odebrania przez serwer protokołu.
* OPW-O-12 : Jako operator chcę mieć możliowść poprzez telefon komórkowy i barcode sprawdzenia dostarczonych protokołow na serwer (z kilku podleglych podemnie komisji)
* OPW-O-13 : Jako operator instaluję w systemie certyfikat imienny SSL dla przewodniczącego komisji

### Użytkownik
* OPW-U-6 : Jako użytkownik jestem w stanie zalogować sie loginem i hasłem otrzymanym od administratora
* OPW-U-7 :  Jako użytkownik jestem w stanie w systemie wypełnić elektroniczny formularz protokołu wraz z załaczeniem zdjęc protokołu
* OPW-U-8 : Jako użytkownik mam dostęp do formularza protokołu, który uzupełniany jest automatycznie o podstawowe dane takie jak:  data, godzina protokołu, data otwarcia lokalu i zamknięcia ( podpowiedzi do wyspecyfikowania )
* OPW-U-9 : Jako użytkownik mam możliwość wydrukowania pustego i wypełnionego formularza protokołu
*  OPW-U-10 : Jako użytkownik przy wpisywaniu formularza protokołu - formularz zostaje walidowany ( do wyspecyfikowania ) Twarde i Miekkie błedy
* OPW-U-11 : Jako użytkownik wysyłam podpisany i uwierzytelniony protokół i otrzymuję raport błędów protokołu 
* OPW-U-12 : Jako użytkownik mam możliwość poprawiania protokołu wraz z wyjaśnieniem poprawki i naniesieniem nowej wersji protokołu
* OPW-U-13 : Jako użytkownik otrzymuję komunikat i potwierdzenie wysłania i odebrania przez serwer protokołu
* OPW-U-14 : Jako użytkownik jestem w stanie zapisać/odczytać elektroniczny formularz protokołu z/na zewnętrznym nośniku w postaci pliku
* OPW-U-15 : Jako użytkownik jestem w stanie wysłać wypełniony formularz na serwer

### Gość

* OPW-G-3 : Jako gość potrzebuje konta i loginu i hasła do zalogowania sie do systemu


