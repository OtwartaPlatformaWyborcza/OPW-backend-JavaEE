# User story - kompletna lista 
Rozróżniamy dwa warianty OPW: prosty (na wybory prezydenckie 2015) i rozszerzony. Pojedyncze user story organizujemy z perspektywy użytkownika.  
Schemant nazewnictwa: OPW-{perspektywa: A, U, G, O, K}-{numer}. 


## Wariant prosty Prezydent 2015 
Jest to lista minimalnych wymagań by obsłużyć nadchodzące wybory. 

### Administrator
* OPW-A-1 : Jako administrator mogę zalogować się do systemu i uzyskać dostęp do stron administracyjnych
* OPW-A-2 : Jako administrator definiuję / importuję komisje obwodowe (nr komisji, adres, przynależność do komisji okręgowej)
* OPW-A-3 : Jako administrator definiuję / importuję komisje okręgowe (nr komisji oraz adresy)
* OPW-A-4 : Jako administrator jestem w stanie dokonać wirtualnego podziału państwa na okręgi i obwody wyborcze 
* OPW-A-5 : Jako administrator jestem w stanie dodać pojedyncze konto użytkownika w przeglądarce 
* OPW-A-6 : Jako administrator jestem w stanie wykonać import listy użytkowników z pliku CSV
* OPW-A-7 : Jako administrator chcę wykonać import komisji okręgowych bezpośrednio z pliku CSV 
* OPW-A-8 : Jako administrator chcę, po opublikowaniu przez PKW oficjalnej listy kandydatów, zamknąć listę kandydatów (przejść w tryb read-only) w OPW. 
* OPW-A-9 : Jako administrator chcę zarządzać listą Komisji Obwodowych przypisanych do konkretnego użytkownika. 

### Użytkownik 
* OPW-U-1 : Jako użytkownik mogę się zalogować i wylogować
* OPW-U-2 : Jako użytkownik widzę po zalogowaniu się listę moich komisji obwodowych
* OPW-U-3 : Jako użytkownik widzę po wybraniu komisji podstawowe informacje: listę kandydatów, listę protokołów jak i formularz liczb wyborczych
* OPW-U-4 : Bezpośrednia walidacja błędów twardych w przeglądarce
* OPW-U-5 : Upload liczb wyborczych do serwera OPW
* OPW-U-6 : Aktywacja konta


### Gość

* OPW-G-1 : Jako gość jestem w stanie wejść na stronę www i wyświetlić wyniki z danej komisji wyborczej / gminy / powiatu / okręgu / województwa / Polski.
* OPW-G-2 : Jako gość mam limitowany dostęp do serwera i możliwość wyswietlania wyników aby nie przeciążyć serwera  

### Technologia
* OPW-T-1 : Wykonanie dokumentacji REST API w swagger.io 
* OPW-T-2 : Integracja SFL4J jako loggera
* OPW-T-3 : Migracja z EclipseLink na Hibernate +envers 
* OPW-T-4 : Generowanie E-Mail poprzez szablony FreeMarker
* OPW-T-5 : Rozbicie kolumny `name` w bazie danych na `firstname` i `lastname` 
* OPW-T-6 : Autoryzacja i autentykacja na bazie JAAS
* OPW-T-7 : Logowanie dla REST i JSF
* OPW-T-

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









