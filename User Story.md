# User story - kompletna lista 
Rozróżniamy dwa warianty OPW: prosty (na wybory prezydenckie 2015) i rozszerzony. Pojedyńcze user story organizujemy z perspektywy użytkownika.  
Schemant nazewnictwa: OPW-{perspektywa: A, U, G}-{numer}. 


## Wariant prosty Prezydent 2015 
Jest to lista minimalnych wymagan by obsłużyc nadchodzace wybory. 

### Administrator
* OPW-A-1 : Jako administrator moge zalogować się do systemu i uzyskać dostęp do stron administracyjnych.
* OPW-A-2 : Jako administrator definiuje / importuje komisje obwodowe (nr komisji, adres, przynależność do komisji okręgowej).
* OPW-A-3 : Jako administrator definiuje / importuje komisje okręgowe (nr komisji oraz adresy).
* OPW-A-4 : Jako administrator jestem w stanie dokonać wirtualnego podziału państwa na okręgi i obwody wyborcze. 
* OPW-A-5 : Jako administrator jestem w stanie dodać pojedyńcze konto użytkownika w przeglądarce. 
* OPW-A-6 : Jako administrator jestem w stanie wykonać import listy użytkowników z pliu CSV.
* OPW-A-7 : Jako administrator chcę wykonać import komisji okręgowych bezpośrednio z pliku CSV. 
* OPW-A-8 : 
* OPW-A-9 : 
* OPW-A-10 : 


### Użytkownik 




## Wariant rozszeżony
 

### Administrator 
* Jako administrator po poprawnym zalogowaniu sie otrzymuje mozliwość:
  * Generowania haseł dla Koordynatórów Gminnych, Operatorów i Przewodniczących oraz ich usuwania bądz reedytowania
* Jako administrator definiuje/ importuje koordynatorów gminnych (imie, nazwisko, telefon, mail, przypisane obwody najczesciej gmina badz dzielnica ) - Import XLS
6. Jako administrator zakładam konta  uzytwkonom  i łącze je z odpowiednimi komisjami
6a  Jako administrator zakładam konta koordynatorom gminy  i łącze je z odpowiednimi gminami/zestawami komisji - funkcja docelowa w przyszlosci. 

7. Jako administrator zatwierdzam requesty certyfikatów imienienych dla przewodniczych i operatorów informatycznych - funkcja docelowa w przyszlosci. 
8. Jako administrator wysyłam hasła uzytkownikom 
9. Jako administrator wysyłam hasła koordynatorom - funkcja docelowa w przyszlosci
10. Jako administrator wprowadzam kandydatów i mam mozliwosc ich edycji  
11. Jako administrator mam narzedzie do weryfikacji spływajacych danych ( protokołow z konkretnych komisji wraz z warningami ) 
12. 



### Koordynator Gminy  (rola docelowa jesli bedziemy integrowac sie z PKW)
1. Jako koordynator wprowadzam zatwierdzam i edytuje składy komisji lokalnych dostarczonych przez operatorów importując dane z / do XLS  oraz systemu (Imie, Nazwisko, Pesel, mail, telefon, funkcja czlonka komisji)
2. Jako koordynator wprowadzam nadmiarową ilość członków komisji dla danej komisji, i mam mozliwość w przeddzień wyborów zatwierdzić ostateczny sklad komisji. 
3. Jako koordynator mam dostęp do częsci systemu który waliduje członków komisji i ich poprawność przed ostatecznym zaakceptowaniem składu komisji ( walidacja po PESEL, zameldowaniu, czy wystepuje dany członek komisji tylko w jednej komisji)
4. Jako koordynator najlepiej jakbym mial dostep w systemie do bramki sms-owej przez którą mógłbym wysyłać informacje operatorom pracującym dla mnie.
5. Jako koordynator mam dostęp do wygenerowanych haseł przed administratora dla operatorów i uzytkowników.
6. Jako koordynator chciałbym mieć mozliwosc koordynowania działan po przes wysylanie sms przez bramke sms z pozycji systemu z informacjami dla operatorów. 
7. Jako koordynator dystrybuuje otrzymane certyfikaty dla Przewodiczących komisji od KBW


### Operator (rola docelowa jesli  bedziemy integrowac sie z PKW)
1. Jako operator zbieram informacje od/i o członkach komisji ( imię, nazwisko, nr komisji, Z ramienia jakiej partii bądz od kogo dany członek jest delegowany, data powołania , PESEL członków, Czy nie kandydyją w wyborach ) 
2. Jako operator uzyskane dane o członkach komisji jestem wstanie zaimportowac z pliku XLS do systemu
3. Jako operator mam dostęp do haseł uzytkownków.
4. Jako operator wpisuję  i uzupełniam protokół.
5. Jako operator mam dostęp do formularza protokłółu który uzupeniany jest automatycznie o podstawowe dane takie jak. data, godzina protokołu, adres komisji, numer komisji.
6. Jako operator mam mozliwosc wydrukowania pustego i wypełnbionego formularza protokołu
7. Jako operator przy wpisywaniu formularza protokołu - formularz zostaje walidowany ( do wyspecyfikowania ) Twarde błedy od razu, Miekkie Pozniej ( np po stronie serwera)
8.  Jako operator przedstawiam wypełniony protokół do podpisania i uwiezytelnienia dla przewodniczącego komisji.(uzytkownika)
9. Jako operator wysyłam podpisany i uwierzytelniony protokół i otrzymuje raport błedów protokołu ( przetworzonego przez serwer )
10. Jako operator mam możliwosć poprawiania protokołu wraz z wyjasnieniem poprawki i  naniesieniem nowej wersji ptotokołu.
11. Jako Operator mam możliwosc "zgrania" protokołu na nosnik CD badz pendrive i przekazuje go w postaci fizycznej do koordynatora
12. Jako operator otrzymuje komunikat i potwierdzenie wysłania i odebrania przez serwer protokołu. 
13. Jako operator chce miec mozliowść po przez telefon komórkowy i barcode sprawdzenia dostarczonych protokołow na serwer ( z kilku podleglych dla mnie komisji )
14. Jako operator instaluje w systemie certyfikat imienny SSL dla przewodniczacego komisji 
 


### Użytkownik
1. Jako użytkownik jestem w stanie zalogować sie loginem i hasłem otrzymanym od administratora.
2. Jako użytkownik jestem w stanie w systemie wypełnić elektroniczny formularz protokołu wraz z załaczeniem 3 zdjęc protokołu. 
3. Jako użytkownik mam dostęp do formularza protokłółu który uzupeniany jest automatycznie o podstawowe dane takie jak. data, godzina protokołu, data otwarcia lokalu i zamkniecia ( podpowiedzi do zaakceptowania) 
4. Jako uzytkownik mam mozliwosc wydrukowania pustego i wypełnionego formularza protokołu
5. Jako uzytkownik przy wpisywaniu formularza protokołu - formularz zostaje walidowany ( do wyspecyfikowania ) Twarde i miekkie błedy. 
6. Jako uzytkownik wysyłam podpisany i uwierzytelniony protokół i otrzymuje raport błedów protokołu - funkcja docelowa w przyszlosci 
7. Jako uzytkownik mam mozliwosć poprawiania protokołu wraz z wyjasnieniem poprawki i  naniesieniem nowej wersji protokołu.
8.  Jako uzytkownik otrzymuje komunikat i potwierdzenie wysłania i odebrania przez serwer protokołu
9. Jako użytkownik jestem wstanie zapisac/odczytac elektroniczny formularz protokołu na zewnetrzym nosniku w postaci pliku
10. Jako uzytkownik jestem wstanie wysłac wypełnony formularz na serwer



### Gość

1. Jako gość  jestem wstanie wejsc na strone www i wyswietlic wyniki z danej komisji wyborczej. 





