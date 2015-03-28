# User story - kompletna lista 
Rozróżniamy dwa warianty OPW: prosty (na wybory prezydenckie 2015) i rozszerzony. Pojedyncze user story organizujemy z perspektywy użytkownika.  
Schemant nazewnictwa: OPW-{perspektywa: A, U, G}-{numer}. 


## Wariant prosty Prezydent 2015 
Jest to lista minimalnych wymagań by obsłużyć nadchodzące wybory. 

### Administrator
* OPW-A-1 : Jako administrator mogę zalogować się do systemu i uzyskać dostęp do stron administracyjnych.
* OPW-A-2 : Jako administrator definiuję / importuję komisje obwodowe (nr komisji, adres, przynależność do komisji okręgowej).
* OPW-A-3 : Jako administrator definiuję / importuję komisje okręgowe (nr komisji oraz adresy).
* OPW-A-4 : Jako administrator jestem w stanie dokonać wirtualnego podziału państwa na okręgi i obwody wyborcze. 
* OPW-A-5 : Jako administrator jestem w stanie dodać pojedyncze konto użytkownika w przeglądarce. 
* OPW-A-6 : Jako administrator jestem w stanie wykonać import listy użytkowników z pliu CSV.
* OPW-A-7 : Jako administrator chcę wykonać import komisji okręgowych bezpośrednio z pliku CSV. 
* OPW-A-8 : 
* OPW-A-9 : 
* OPW-A-10 : 


### Użytkownik 
* OPW-U-1 : Jako użytkownik mogę się zalogować i wylogować.
* OPW-U-2 : Jako użytkownik widzę po zalogowaniu się listę moich komisji obwodowych.
* OPW-U-3 : Jako użytkownik widzę po wybraniu komisji: podstawowe informacje, listę kandydatów, listę protokołów jak i formularz liczb wyborczych.
* OPW-U-4 : Bezpośrednia walidacja błędów twardych w przeglądarce.
* OPW-U-5 : Upload liczb wyborczych do serwera OPW.
* OPW-U-6 :  


### Technologia
* OPW-T-1 : Wykonanie dokumentacji REST API w swagger.io 
* OPW-T-2 : 
* OPW-T-3
* OPW-T-4
* OPW-T-5


## Wariant rozszeżony
 

### Administrator 
* Jako administrator po poprawnym zalogowaniu się otrzymuj możliwość:
  * Generowania haseł dla Koordynatórów Gminnych, Operatorów i Przewodniczących oraz ich usuwania bądz reedytowania
* Jako administrator definiuję/ importuję koordynatorów gminnych (imię, nazwisko, telefon, mail, przypisane obwody najcześciej gmina bądź dzielnica ) - Import XLS
6. Jako administrator zakładam konta użytkownikom  i łączę je z odpowiednimi komisjami
6a.  Jako administrator zakładam konta koordynatorom gminy i łączę je z odpowiednimi gminami/zestawami komisji - funkcja docelowa w przyszłości. 

7. Jako administrator zatwierdzam requesty certyfikatów imiennych dla przewodniczących i operatorów informatycznych - funkcja docelowa w przyszłości. 
8. Jako administrator wysyłam hasła użytkownikom 
9. Jako administrator wysyłam hasła koordynatorom - funkcja docelowa w przyszłości
10. Jako administrator wprowadzam kandydatów i mam możliwość ich edycji  
11. Jako administrator mam narzędzie do weryfikacji spływajacych danych (protokołów z konkretnych komisji wraz z warningami) 
12. 



### Koordynator Gminy  (rola docelowa jeśli będziemy integrować się z PKW)
1. Jako koordynator wprowadzam, zatwierdzam i edytuję składy komisji lokalnych dostarczonych przez operatorów importując dane z / do XLS  oraz systemu (Imię, Nazwisko, Pesel, mail, telefon, funkcja członka komisji)
2. Jako koordynator wprowadzam nadmiarową ilość członków komisji dla danej komisji, i mam możliwość w przeddzień wyborów zatwierdzić ostateczny skład komisji. 
3. Jako koordynator mam dostęp do części systemu który waliduje członków komisji i ich poprawność przed ostatecznym zaakceptowaniem składu komisji (walidacja po PESEL, zameldowaniu, czy występuje dany członek komisji tylko w jednej komisji)
4. Jako koordynator najlepiej jakbym miał dostęp w systemie do bramki sms-owej przez którą mógłbym wysyłać informacje operatorom pracującym dla mnie.
5. Jako koordynator mam dostęp do wygenerowanych haseł przed administratora dla operatorów i użytkowników.
6. Jako koordynator chciałbym mieć możliwość koordynowania działań poprzez wysyanie sms przez bramkę sms z pozycji systemu z informacjami dla operatorów. 
7. Jako koordynator dystrybuuję otrzymane od KBW certyfikaty dla Przewodiczących komisji.


### Operator (rola docelowa jeśli będziemy integrować się z PKW)
1. Jako operator zbieram informacje od/i o członkach komisji (imię, nazwisko, nr komisji, Komitet Wyborczy delegujący, data powołania, PESEL członków, Czy nie kandydują w wyborach ) 
2. Jako operator uzyskane dane o członkach komisji jestem w stanie zaimportować z pliku XLS do systemu
3. Jako operator mam dostęp do haseł użytkownków.
4. Jako operator wpisuję  i uzupełniam protokół.
5. Jako operator mam dostęp do formularza protokołu który uzupełniany jest automatycznie o podstawowe dane takie jak: data, godzina protokołu, adres komisji, numer komisji.
6. Jako operator mam możliwość wydrukowania pustego i wypełnionego formularza protokołu
7. Jako operator przy wpisywaniu formularza protokołu - formularz zostaje walidowany ( do wyspecyfikowania ) Twarde błedy od razu, Miekkie Pozniej ( np po stronie serwera)
8.  Jako operator przedstawiam wypełniony protokół do podpisania i uwierzytelnienia dla przewodniczącego komisji (użytkownika)
9. Jako operator wysyłam podpisany i uwierzytelniony protokół i otrzymuję raport błędów protokołu ( przetworzonego przez serwer )
10. Jako operator mam możliwość poprawiania protokołu wraz z wyjaśnieniem poprawki i naniesieniem nowej wersji protokołu.
11. Jako Operator mam możliwość "zgrania" protokołu na nosnik CD bądź pendrive i przekazuję go w postaci fizycznej do koordynatora
12. Jako operator otrzymuję komunikat i potwierdzenie wysłania i odebrania przez serwer protokołu. 
13. Jako operator chcę mieć możliowść poprzez telefon komórkowy i barcode sprawdzenia dostarczonych protokołow na serwer (z kilku podleglych mnie komisji)
14. Jako operator instaluję w systemie certyfikat imienny SSL dla przewodniczącego komisji 
 


### Użytkownik
1. Jako użytkownik jestem w stanie zalogować sie loginem i hasłem otrzymanym od administratora.
2. Jako użytkownik jestem w stanie w systemie wypełnić elektroniczny formularz protokołu wraz z załaczeniem 3 zdjęc protokołu. 
3. Jako użytkownik mam dostęp do formularza protokołu, który uzupeniany jest automatycznie o podstawowe dane takie jak. data, godzina protokołu, data otwarcia lokalu i zamknięcia ( podpowiedzi do zaakceptowania) 
4. Jako użytkownik mam możliwość wydrukowania pustego i wypełnionego formularza protokołu
5. Jako użytkownik przy wpisywaniu formularza protokołu - formularz zostaje walidowany ( do wyspecyfikowania ) Twarde i miekkie błedy. 
6. Jako użytkownik wysyłam podpisany i uwierzytelniony protokół i otrzymuję raport błędów protokołu - funkcja docelowa w przyszłości 
7. Jako użytkownik mam możliwość poprawiania protokołu wraz z wyjaśnieniem poprawki i naniesieniem nowej wersji protokołu.
8.  Jako użytkownik otrzymuję komunikat i potwierdzenie wysłania i odebrania przez serwer protokołu
9.  Jako użytkownik jestem w stanie zapisać/odczytać elektroniczny formularz protokołu na zewnętrznym nośniku w postaci pliku
10. Jako użytkownik jestem w stanie wysłać wypełniony formularz na serwer



### Gość

1. Jako gość jestem w stanie wejść na stronę www i wyświetlić wyniki z danej komisji wyborczej / gminy / powiatu / okręgu / województwa / Polski.





