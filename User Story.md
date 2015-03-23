# User story - kompletna lista 


### Administrator 
1. Jako administrator moge zalogować się do systemu i uzyskać dostęp do stron administracyjnych.  
2. Jako administrator po poprawnym zalogowaniu sie otrzymuje mozliwość:
   Generowania haseł dla Koordynatórów Wyborów, Operatorów i Uzytkowników oraz ich usuwania bądz reedytowania
4. Jako administrator definiuje / importuje komisje okręgowe i należące do nich komisje obwodowe (nr komisji oraz adresy)
5. Jako administrator definiuje/ importuje koordynatorów wyborów (imie, nazwisko, telefon, mail, przypisane obwody najczesciej gmina badz dzielnica ) - Import XLS
6. Jako administrator zakładam konta koordynatorom i łącze je z odpowiednimi komisjami i obwodami
7.  Jako administrator zakładam konta operatorom i użytkownikom (przewodniczącym komisji obwodowych badz/i wolentariuszom, męzom zaufania) i takze łacze je z  odpowiednimi komisjami
8.  



### Koordynator Wyborów (rola docelowa jesli bedziemy integrowac sie z PKW)
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
10. Jako operator mam mozliwosć poprawiania protokołu wraz z wyjasnieniem poprawki i  naniesieniem nowej wersji ptotokołu.
11. Jako Operator mam mozliwosc "zgrania" protokołu na nosnik CD badz pendrive i przekazuje go w postaci fizycznej do koordynatora
12. Jako operator otrzymuje komunikat i potwierdzenie wysłania i odebrania przez serwer protokołu. 
13. Jako operator chce miec mozliowść po przez telefon komórkowy i barcode sprawdzenia dostarczonych protokołow na serwer ( z kilku podleglych dla mnie komisji )
14. Jako operator instaluje w systemie certyfikat imienny SSL dla przewodniczacego komisji 
 


### Użytkownik
1. Jako użytkownik jestem wstanie zalogować sie loginem i hasłem otrzymanym od administratora.
2. Jako użytkownik jestem wstanie w systemie wypełnić elektroniczny formularz protokołu wraz z załaczeniem 3 zdjęc protokołu. 
3. Jako użytkownik mam dostęp do formularza protokłółu który uzupeniany jest automatycznie o podstawowe dane takie jak. data, godzina protokołu, adres komisji, numer komisji
4. Jako uzytkownik mam mozliwosc wydrukowania pustego i wypełnionego formularza protokołu
5. Jako uzytkownik przy wpisywaniu formularza protokołu - formularz zostaje walidowany ( do wyspecyfikowania ) Twarde błedy od razu, Miekkie Pozniej ( np po stronie serwera)
6. Jako uzytkownik wysyłam podpisany i uwierzytelniony protokół i otrzymuje raport błedów protokołu ( przetworzonego przez serwer )
7. Jako uzytkownik mam mozliwosć poprawiania protokołu wraz z wyjasnieniem poprawki i  naniesieniem nowej wersji ptotokołu.
8.  Jako uzytkownik otrzymuje komunikat i potwierdzenie wysłania i odebrania przez serwer protokołu
3. Jako użytkownik jestem wstanie zapisac elektroniczny formularz protokołu na zewnetrzym nosniku w postaci pliku
4. Jako uzytkownik mam mozliwosc "zgrania" protokołu na nosnik CD badz pendrive i przekazuje go w postaci fizycznej do koordynatora
4. Jako uzytkownik jestem wstanie wysłac wypełnony formularz na serwer
5. Jako uzytkownik otrzymuje komunikat i potwierdzenie o wysłaniu protokołu i odebraniu go przez serwer.


### Gość

1. Jako gość  jestem wstanie wejsc na strone www i wyswietlic wyniki z danej komisji wyborczej. 





