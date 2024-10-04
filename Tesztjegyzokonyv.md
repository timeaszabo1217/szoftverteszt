# Tesztjegyzőkönyv

Az alábbi tesztdokumentum a `2023_IB153I-12_A` projekt funkcióihoz készült. Felelőse: `Durucz Ádám` 

``` 
A tesztelési dokumentáció részletesen bemutatja és leírja a Projekttervben meghatározott főbb funkciók tesztelési procedúráját, beleértve a specifikus teszteseteket és azok eredményeit. 
``` 

## 1. Teszteljárások (TP)

### 1.1. Regisztráció
- **Azonosító:** TP-01
- **Tesztesetek:** TC-01, TC-02, TC-03
- **Leírás:** A regisztrációs folyamat tesztelése során gondosan ellenőrizzük a felhasználói adatok helyes rögzítését és a felhasználói fiókok sikeres létrehozását. A teszt magában foglalja az űrlapmezők érvényességének ellenőrzését, valamint a visszajelzések és hibaüzenetek helyes megjelenítését.

    0. lépés: Nyissuk meg a weboldalt.
    1. lépés: Mozgassuk az egeret a jobb felső sarokban található felhasználói ikonra, és válasszuk ki a megjelenő menüből a `Regisztráció` opciót.
    2. lépés: A form kitöltésekor három kötelező mezőt kell kitölteni: a `Név`, az `Email` és a `Jelszó` mezőket. Ezenkívül egy legördülő menü segítségével ki kell választani a `Jogosultság` szintet. Az email-címnek a szabványos formátumnak kell megfelelnie. A jelszónak legalább négy karakterből kell állnia.
    3. lépés: Miután kitöltöttük az összes mezőt, kattintsunk a `Regisztráció` gombra.
    4. lépés: Sikeres regisztráció után automatikusan a főoldalra irányít minket az alkalmazás. Ha hiba történik, az alkalmazás jelzi, hogy melyik mezőt töltöttük ki helytelenül. _Elvárt eredmény:_ A főoldalra irányít minket az alkalmazás.

### 1.2. Bejelentkezés
- **Azonosító:** TP-02
- **Tesztesetek:** TC-01, TC-02, TC-03, TC-04, TC-05
- **Leírás:** A bejelentkezési folyamat tesztelésekor részletesen átvizsgáljuk a felhasználói azonosítási eljárásokat. A teszt magában foglalja a beviteli mezők, mint például a felhasználónév és jelszó mezők érvényességének ellenőrzését. Különös figyelmet fordítunk arra, hogy a rendszer hogyan reagál helytelen bejelentkezési adatok esetén.

    0. lépés: Nyissuk meg a weboldalt.
    1. lépés: Mozgassuk az egeret a jobb felső sarokban található felhasználói ikonra, és válasszuk ki a megjelenő menüből a `Bejelentkezés` opciót.
    2. lépés: A bejelentkezési folyamat során két kötelező mezőt kell kitölteni: az `Email` és a `Jelszó` mezőket. A bejelentkezés előtt minden esetben regisztrálni kell.
    3. lépés: Miután kitöltöttük az összes mezőt, kattintsunk a `Bejelentkezés` gombra. _Elvárt eredmény:_ Sikeres bejelentkezés után automatikusan a főoldalra irányít minket az alkalmazás. Ha hiba történik, az alkalmazás jelzi a felhasználónak.

### 1.3. Kijelentkezés
- **Azonosító:** TP-03
- **Tesztesetek:** TC-01, TC02, TC-03
- **Leírás:** Ellenőrizzük, hogy a kijelentkezési folyamat megfelelően megszakítja-e a munkamenetet és törli a felhasználói adatokat a kliens oldalról, biztosítva a biztonságos kijelentkezést.

    0. lépés: Nyissuk meg a weboldalt, és jelentkezzünk be.
    1. lépés: Mozgassuk az egeret a jobb felső sarokban található felhasználói ikonra, és válasszuk ki a megjelenő menüből a `Kijelentkezés` opciót. _Elvárt eredmény:_ Az alkalmazásnak minden esetben meg kell szakítania a munkamenetet, majd a főoldalra kell irányítania. 

### 1.4. Biztonsági mentés készítése
- **Azonosító:** TP-04
- **Tesztesetek:** TC-01
- **Leírás:** A biztonsági mentés tesztelése során alaposan megvizsgáljuk, hogy a rendszer megfelelően rögzíti-e az összes lényeges adatot JSON formátumban.

    0. lépés: A mentés csak abban az esetben működik, ha a szerveren fut a webalkalmazás.
    1. lépés: Minden nap automatikusan történik mentés 03:10-kor, emberi beavatkozás nélkül. Elvárt eredmény:_ Az időbélyeggel ellátott JSON fájlban megtalálható az összes adat.

### 1.5. Felhasználó törlése (Admin oldal)
- **Azonosító:** TP-05
- **Tesztesetek:** TC-01, TC-02
- **Leírás:** A teszt során azt vizsgáljuk, hogy amennyiben egy adminisztrátor töröl egy felhasználót, az adott felhasználó összes adata törlődik-e minden adatbázis táblából és a teljes rendszerből.

    0. lépés: Nyissuk meg a weboldalt, és jelentkezzünk be egy adminisztrátori fiókkal.
    1. lépés:Navigáljunk az `Admin` oldalra, és ott válasszuk ki a `Felhasználók` menüpontot.
    2. lépés: A táblázatban válasszuk ki a törölni kívánt felhasználót, majd kattintsunk a `Törlés` gombra. _Elvárt eredmény:_ A felhasználó eltűnik a táblázatból, és az adatbázisból is törlődik.

### 1.6. Időpont hozzáadás (Admin oldal)
- **Azonosító:** TP-06
- **Tesztesetek:** TC-01, TC-02, TC-03
- **Leírás:** A tesztelési folyamat során ellenőrizzük, hogy az időpont hozzáadásakor minden megfelelően működik-e.

    0. lépés: Nyissuk meg a weboldalt, és jelentkezzünk be egy adminisztrátori fiókkal.
    1. lépés: Navigáljunk az `Admin` oldalra, és ott válasszuk ki a `Időpontok` menüpontot.
    2. lépés: Válasszuk ki a hozzáadni kívánt dátumot a `Hozzáadandó Dátum` beviteli mezőben.
    3. lépés: Kattintsunk az `Időpont Hozzáadása` gombra, hogy hozzáadjuk az időpontot a rendszerhez._Elvárt eredmény:_ A hozzáadott időpont megjelenik az elérhető időpontok között.

### 1.7. Időpont módosítás (Admin oldal)
- **Azonosító:** TP-07
- **Tesztesetek:** TC-01, TC02, TC-03
- **Leírás:** A tesztelési folyamat során ellenőrizzük, hogy az időpont módosításakor minden megfelelően működik-e.

    0. lépés: Nyissuk meg a weboldalt, és jelentkezzünk be egy adminisztrátori fiókkal.
    1. lépés: Navigáljunk az `Admin` oldalra, és ott válasszuk ki a `Időpontok` menüpontot.
    2. lépés: Válasszuk ki a módosítandó időpontot a `Változtatnivaló időpont` legördülő menüből.
    3. lépés: Válasszuk ki a kívánt dátumot az alatta lévő beviteli mezőben.
    4. lépés: Kattintsunk az `Időpont Módosítása` gombra, így módosítva az időpontot. _Elvárt eredmény:_ Az időpont sikeresen módosul.

### 1.8. Időpont törlése (Admin oldal)
- **Azonosító:** TP-08
- **Tesztesetek:** TC-01, TC02, TC-03
- **Leírás:** A tesztelési folyamat során ellenőrizzük, hogy az időpont törlésekor minden megfelelően működik-e.

    0. lépés: Nyissuk meg a weboldalt, és jelentkezzünk be egy adminisztrátori fiókkal.
    1. lépés: Navigáljunk az `Admin` oldalra, és ott válasszuk ki a `Időpontok` menüpontot.
    2. lépés: Válasszuk ki a törlendő időpontot a `Törlendő Időpont` legördülő menüből.
    3. lépés: Kattintsunk az `Időpont Törlése` gombra, így törölve az időpontot. _Elvárt eredmény:_ Az időpont sikeresen törlődik.

### 1.9. Időpontfoglalás
- **Azonosító:** TP-09
- **Tesztesetek:** TC-01, TC-02, TC-03
- **Leírás:** A tesztfolyamat során gondosan ellenőrizzük az időpontfoglalási rendszer működését, hogy megbizonyosodjunk arról, hogy minden része hibátlanul működik.

    0. lépés: Nyissuk meg a weboldalt, és jelentkezzünk be.
    1. lépés: Navigáljunk az `Időpontfoglalás` oldalra.
    2. lépés: Válasszuk ki egy időpontot a `Elérhető időpontok` legördülő menüből.
    3. lépés: Kattintsunk a `Foglalás` gombra, így elfoglalva az időpontot. _Elvárt eredmény:_ A `Lefoglalt időpontok` résznél a táblázatban láthatóvá válik az újonnan foglalt időpont.

### 1.10. Fiók törlése
- **Azonosító:** TP-10
- **Tesztesetek:** TC-01, TC-02, TC-03
- **Leírás:** Ellenőrizzük, hogy a felhasználók képesek-e magukat törölni a rendszerből.

    0. lépés: Nyissuk meg a weboldalt, és jelentkezzünk be.
    1. lépés: Navigáljunk az `Profil` oldalra.
    3. lépés: Kattintsunk a `Fiók törlése` gombra, így törövel magunkat a rendszerből. _Elvárt eredmény:_ A fiók törlődik és azt követően az oldal a főoldalra irányít át.

### 1.11. Név és email-cím módosítás
- **Azonosító:** TP-11
- **Tesztesetek:** TC-01, TC-02, TC-03, TC-04, TC-05
- **Leírás:** Teszteljük, hogy ha a felhasználó megváltoztatja a nevét és az email-címét, akkor azok a változások helyesen módosulnak-e a rendszerben.

    0. lépés: Nyissuk meg a weboldalt, és jelentkezzünk be.
    1. lépés: Navigáljunk az `Profil` oldalra.
    2. lépés: Írjuk be a kívánt új értékeket a `Név` és `Email` mezőkbe.
    3. lépés: Kattintsunk a `Mentés` gombra, így módosítva az adatokat. _Elvárt eredmény:_ A felhasználó adatai sikeresen frissülnek a módosítások után.

### 1.12. Jelszó módosítás
- **Azonosító:** TP-12
- **Tesztesetek:** TC-01, TC-02, TC-03, TC-04, TC-05, TC-06
- **Leírás:** Teszteljük, hogy ha a felhasználó megváltoztatja a jelszavát, akkor a változások helyesen módosulnak-e a rendszerben.

    0. lépés: Nyissuk meg a weboldalt, és jelentkezzünk be.
    1. lépés: Navigáljunk az `Profil` oldalra.
    2. lépés: Írjuk be a megfelelő adatokat a `Jelenlegi jelszó`, `Új jelszó`, és `Jelszó megerősítése` mezőkben.
    3. lépés: Kattintsunk a `Jelszó változtatása` gombra, így módosítva a jelszót. _Elvárt eredmény:_ A felhasználó csak az új jelszóval tud bejelentkezni.

### 1.13. Jogosultságellenőrés
- **Azonosító:** TP-13
- **Tesztesetek:** TC-01, TC-02, TC-03
- **Leírás:** Teszteljük, hogy a felhasználó csak a saját jogosultságának megfelelő oldalakat érheti el.

    0. lépés: Nyissuk meg a weboldalt, jelentkezzünk be.
    1. lépés: Navigáljunk bármelyik oldalra, akár URL-en keresztül. _Elvárt eredmény:_ Ha eleget tesz a jogosultságunk az oldal elérési feltételeinek, megjelenik az oldal, ha nem, akkor hibaüzenetet kapunk.

## 2. Tesztesetek (TC)

### 2.1. Regisztráció

#### 2.1.1. TC-01
- **TP:** TP-01
- **Leírás:** Helyes adatokat adunk meg minden mezőben. A folyamat sikerességét az jelzi, ha a kezdőoldalon találjuk magunkat, ahol a munkamenet elindul.
- **Bemenet:** `Név` = Tetszőleges bemenet ; `E-mail` = Tetszőleges bemenet, amely megfelel az email-cím formátumnak. `Jelszó` = A jelszónak legalább négy karakterből kell állnia. `Jogosultság` = Kiválasztható 'Admin' vagy 'Felhasználó' szerepkör is.
- **Művelet:** A `Regisztráció` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az alkalmazás a kezdőlapra navigál, ahol a munkamenet elkezdődik.

#### 2.1.2. TC-02
- **TP:** TP-01
- **Leírás:** Ebben a tesztesetben az input mezőket üresen hagyjuk, és megfigyeljük, hogy a rendszer hogyan reagál erre az esetre.
- **Bemenet:** `Név` = Üresen hagyjuk. ; `E-mail` = Üresen hagyjuk. `Jelszó` = Üresen hagyjuk. `Jogosultság` = Kiválasztható 'Admin' vagy 'Felhasználó' szerepkör is.
- **Művelet:** A `Regisztráció` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A rendszer figyelmeztet, hogy minden mező kitöltése kötelező.

#### 2.1.3. TC-03
- **TP:** TP-01
- **Leírás:** Olyan email-címet adunk meg, amely már használatban van, más felhasználónál.
- **Bemenet:** `Név` = Tetszőleges bemenet ; `E-mail` = Olyan email-cím, amellyel már korábban történt regisztráció. `Jelszó` = A jelszónak legalább négy karakterből kell állnia. `Jogosultság` = Kiválasztható 'Admin' vagy 'Felhasználó' szerepkör is.
- **Művelet:** A `Regisztráció` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az alkalmazás figyelmeztet, hogy a megadott email-cím már használatban van.

### 2.2. Bejelentkezés

#### 2.2.1. TC-01
- **TP:** TP-02
- **Leírás:** Helyes adatokat adunk meg minden mezőben. A folyamat sikerességét az jelzi, ha a főoldalon találjuk magunkat, ahol a munkamenet elindul.
- **Bemenet:** `E-mail` = Létező regisztrált email-cím. `Jelszó` = A regisztráció során megadott jelszó.
- **Művelet:** A `Bejelentkezés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az alkalmazás a főoldalra navigál, ahol a munkamenet elkezdődik.

#### 2.2.2. TC-02
- **TP:** TP-02
- **Leírás:** Ebben a tesztesetben mindkét input mezőt üresen hagyjuk, és megfigyeljük, hogy a rendszer hogyan reagál erre az esetre.
- **Bemenet:** `E-mail` = Üresen hagyjuk. `Jelszó` = Üresen hagyjuk.
- **Művelet:** A `Bejelentkezés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A rendszer figyelmeztet, hogy mindkét mező kitöltése kötelező.

#### 2.2.3. TC-03
- **TP:** TP-02
- **Leírás:** Rossz jelszót adunk meg a bejelentkezés során.
- **Bemenet:** `E-mail` = Létező regisztrált email-cím `Jelszó` = Helytelen jelszó.
- **Művelet:** A `Bejelentkezés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az alkalmazás jelzi, hogy a bejelentkezés sikertelen volt.

#### 2.2.4. TC-04
- **TP:** TP-02
- **Leírás:** Ebben a tesztesetben egy érvényes e-mail címet adunk meg, de a jelszót hagyjuk üresen.
- **Bemenet:** `E-mail` = Létező regisztrált email-cím `Jelszó` = Üresen hagyjuk.
- **Művelet:** A `Bejelentkezés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A rendszer figyelmeztet, hogy a jelszó mező kitöltése kötelező.

#### 2.2.5. TC-05
- **TP:** TP-02
- **Leírás:** Megpróbálunk bejelentkezni egy nem regisztrált e-mail címmel és bármilyen jelszóval.
- **Bemenet:** `E-mail` = Nem regisztrált e-mail-cím. `Jelszó` = Bármilyen jelszó.
- **Művelet:** A `Bejelentkezés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az alkalmazás jelzi, hogy a bejelentkezés sikertelen volt.

### 2.3. Kijelentkezés

#### 2.3.1. TC-01
- **TP:** TP-03
- **Leírás:** Ellenőrizzük, hogy valósan kijelentkezik-e a felhasználó és minden esetben a kezdőoldalra dob-e minket, ha felhasználói fiókot használunk.
- **Bemenet:** Belépünk átlag felhasználói fiókkal.
- **Művelet:** Főoldalról megnyitjuk a profil fület, az egér rávitelével és rákattintunk a kijelentkezés gombra
- **Elvárt kimenet:** Visszadob a főoldalra, csak a profil fülre való egér rávitellel látjuk, hogy a bejelentkezés funkció megjelent, így kijelentkeztetett minket.

#### 2.3.2. TC-02
- **TP:** TP-03
- **Leírás:** Ellenőrizzük, hogy valósan kijelentkezik-e a felhasználó és minden esetben a kezdőoldalra dob-e minket, ha admin fiókot használunk.
- **Bemenet:** Belépünk admin fiókkal.
- **Művelet:** Főoldalról megnyitjuk a profil fület, az egér rávitelével és rákattintunk a kijelentkezés gombra
- **Elvárt kimenet:** Visszadob a főoldalra, csak a profil fülre való egér rávitellel látjuk, hogy a bejelentkezés funkció megjelent, így kijelentkeztetett minket.

#### 2.3.3. TC-03
- **TP:** TP-03
- **Leírás:** Ellenőrizzük, hogy valósan kijelentkezik-e a felhasználó és minden esetben a kezdőoldalra dob-e minket, ha admin fiókot használunk, de a Felmérések oldaláról próbálunk kijelentkezni a Főoldal helyett.
- **Bemenet:** Belépünk admin fiókkal.
- **Művelet:** Felmérések oldalról megnyitjuk a profil fület, az egér rávitelével és rákattintunk a kijelentkezés gombra
- **Elvárt kimenet:** Visszadob a főoldalra, csak a profil fülre való egér rávitellel látjuk, hogy a bejelentkezés funkció megjelent, így kijelentkeztetett minket.

### 2.4. Biztonsági mentés készítése

#### 2.4.1. TC-01
- **TP:** TP-04
- **Leírás:**  A biztonsági mentés működésének tesztelése annak biztosítása érdekében, hogy megfelelően funkcionál.
- **Bemenet:** Nincs
- **Művelet:** Megvárjuk, hogy elérkezzen az automatikus biztonsági mentés ideje, amely 03:10-kor fog megtörténni anélkül, hogy közbe kellene avatkoznunk.
- **Elvárt kimenet:** Az időbélyeggel ellátott JSON fájlban megtalálható az összes adat.

### 2.5. Felhasználó törlése (Admin oldal)

#### 2.5.1. TC-01
- **TP:** TP-05
- **Leírás:** Ellenőrizzük, hogy az admin képes-e törölni egy felhasználót, és eltűnik-e a felhasználó a kilistázott felhasználók közül.
- **Bemenet:** Felhasználók oldalán egy adott felhasználó törlése.
- **Művelet:** Navigálunk a Felhasználók oldalra, kiválasztunk egy felhasználót és a `Töröl` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az oldal frissül és az törölt felhasználó eltűnik a kilistázott felhasználók közül.

#### 2.5.2. TC-02
- **TP:** TP-05
- **Leírás:** Ellenőrizzük, hogy az admin által törölt felhasználó, képes-e bejelentkezni. 
- **Bemenet:** Felhasználók oldalán egy adott felhasználó törlése adminként.
- **Művelet:** Navigálunk a Felhasználók oldalra, kiválasztunk egy felhasználót és a `Töröl` gomb megnyomásával elküldjük a formot, utána megpróbálunk bejelentkezni a törölt felhasználó adataival.
- **Elvárt kimenet:** A bejelentkezés sikertelen lesz.

### 2.6. Időpont hozzáadás (Admin oldal)

#### 2.6.1. TC-01
- **TP:** TP-06
- **Leírás:** Ellenőrizzük, hogy az időpont sikeresen hozzáadódik-e az adatbázishoz, és megjelenik-e a módosító legördülő menüben.
- **Bemenet:** Választunk a dátumot és órát az időpont hozzáadásához.
- **Művelet:** Az `Időpont Hozzáadása` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az új időpont sikeresen hozzáadódik az adatbázishoz, és az időpont megjelenik a módosító legördülő menüben.

#### 2.6.2. TC-02
- **TP:** TP-06
- **Leírás:** Ellenőrizzük, hogy a felhasználók számára látható-e a felvitt időpont.
- **Bemenet:** Választunk a dátumot és órát az időpont hozzáadásához
- **Művelet:** Az `Időpont Hozzáadása` gomb megnyomásával elküldjük a formot. Átjelentkezünk felhasználói fiókba.
- **Elvárt kimenet:** Az admin által felvitt időpont látható a felhasználók Időpontok menüpontjában.

#### 2.6.3. TC-03
- **TP:** TP-06
- **Leírás:** Ellenőrizzük, hogy az újonnan hozzáadott időpont megjelenik-e a törlés legördülő menüben.
- **Bemenet:** Választunk a dátumot és órát az időpont hozzáadásához
- **Művelet:** Az `Időpont Hozzáadása` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az újonnan hozzáadott időpont megjelenik a törlés legördülő menüben.

### 2.7. Időpont Módosítása (Admin oldal)

#### 2.7.1. TC-01
- **TP:** TP-07
- **Leírás:**  Ellenőrizzük, hogy az admin által kiválasztott és módosított időpont a változtatásokkal jelenik-e meg a módosító listában.
- **Bemenet:** Választott dátum és/vagy időpont módosítása.
- **Művelet:** Az `Időpont Módosítása` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az módisított időpont sikeresen hozzáadódik az adatbázishoz, és az időpont megjelenik a módosító legördülő menüben.

#### 2.7.2. TC-02
- **TP:** TP-07
- **Leírás:**  Ellenőrizzük, hogy az admin által kiválasztott és módosított időpont a változtatásokkal jelenik-e meg a törlő listában.
- **Bemenet:** Választott dátum és/vagy időpont módosítása.
- **Művelet:** Az `Időpont Módosítása` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az módisított időpont sikeresen hozzáadódik az adatbázishoz, és az időpont megjelenik a törlés legördülő menüben.

#### 2.7.3. TC-03
- **TP:** TP-07
- **Leírás:** Ellenőrizzük, hogy a felhasználók számára látható-e a módositott időpont.
- **Bemenet:** Választott dátum és/vagy időpont módosítása.
- **Művelet:** Az `Időpont Módosítása` gomb megnyomásával elküldjük a formot. Átjelentkezünk felhasználói fiókba.
- **Elvárt kimenet:** Az admin által módositott időpont látható a felhasználók Időpontok menüpontjában.

### 2.8. Időpont törlése(Admin oldal)

#### 2.8.1. TC-01
- **TP:** TP-08
- **Leírás:** Az admin esetében ellenőrizzük, hogy az időpont törlése után változnak-e a módosítható időpontok.
- **Bemenet:** Már korábban hozzáadott időpont törlése.
- **Művelet:** Az `Időpont Törlése` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az oldal frissül, és a törölt időpont eltűnik a módosítható időpontok közül.

#### 2.8.2. TC-02
- **TP:** TP-08
- **Leírás:** Az admin esetében ellenőrizzük, hogy az időpont törlése után eltűnik-e az időpont a törölhető időpontok közül.
- **Bemenet:** Már korábban hozzáadott időpont törlése.
- **Művelet:** Az `Időpont Törlése` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az oldal frissül és a törölt időpont eltűnik a törölhető időpontok közül.

#### 2.8.3. TC-03
- **TP:** TP-08
- **Leírás:** Ellenőrizzük, hogy a felhasználók számára eltűnik-e az admin által törölt időpont. 
- **Bemenet:** Már korábban hozzáadott időpont törlése.
- **Művelet:** Adminként az `Időpont Törlése` gomb megnyomásával elküldjük a formot. Átjelentkezünk utána felhasználói fiókba.
- **Elvárt kimenet:** Az admin által törölt időpont eltűnik a felhasználók Időpontok(Időpontfoglalás) menüpontjából.

### 2.9. Időpontfoglalás 

#### 2.9.1. TC-01
- **TP:** TP-09
- **Leírás:**  Ellenőrizzük, hogy az időpontfoglalás sikeresen megtörténik-e.
- **Bemenet:** Időpontfoglalás listából kiválasztunk egy dátumot.
- **Művelet:** Az `Időpontfoglalás` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az oldal kiirja hogy "Sikeres foglalás!" és megjelenik az időpont a foglaltak között.

#### 2.9.2. TC-02
- **TP:** TP-09
- **Leírás:**  Ellenőrizzük, hogy az időpont eltűnik-e az opciók közül.
- **Bemenet:** Időpontfoglalás listából kiválasztunk egy dátumot.
- **Művelet:** Az `Időpontfoglalás` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az legördülő menüből eltűnik a korábban kiválsztott dátum.

#### 2.9.3. TC-03
- **TP:** TP-09
- **Leírás:**  Ellenőrizzük, hogy a lefoglalt időpont megjelenik-e az Adminnak.
- **Bemenet:** Időpontfoglalás listából kiválasztunk egy dátumot.
- **Művelet:** Az `Időpontfoglalás` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az Admin oldalán látható lesz az uj foglalás.

### 2.10. Fiók törlése

#### 2.10.1. TC-01
- **TP:** TP-10
- **Leírás:** Felhasználó esetében akarjuk ellenőrízni, hogy tudja-e törölni a fiókját.
- **Bemenet:** Bejelentkezünk átlag felhasználóval.
- **Művelet:** Navigálunk a Profil oldalra és a `Törlés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A főoldalra irányít és törli a fiókot.

#### 2.10.2. TC-02
- **TP:** TP-10
- **Leírás:** Átlag felhasználó esetében akarjuk ellenőrízni, hogy tudja-e törölni a fiókját, de ebben az esetben nem a kezdő oldalról próbáljuk elérni, hanem a Felmérések oldalról.
- **Bemenet:** Bejelentkezünk átlag felhasználóval.
- **Művelet:** Átkattintunk a Felmérések oldalra, onnan navigálunk a Profil oldalra és a `Törlés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A főoldalra irányít és törli a fiókot.

#### 2.10.3. TC-03
- **TP:** TP-10
- **Leírás:** Felhasználó esetében akarjuk ellenőrízni, hogy tudja-e törölni a fiókját, de ebben az esetben nem a kezdő oldalról próbáljuk elérni, hanem a Leckék oldalról.
- **Bemenet:** Bejelentkezünk átlag felhasználóval.
- **Művelet:** Átkattintunk a Leckék oldalra, onnan navigálunk a Profil oldalra és a `Törlés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A főoldalra irányít és törli a fiókot.

### 2.11. Név és email-cím módosítás

#### 2.11.1. TC-01
- **TP:** TP-11
- **Leírás:** A felhasználó megváltoztatja a nevét és az email-címét és ellenőrizzük, hogy a rendszer helyesen kezeli-e ezeket a változásokat.
- **Bemenet:** `Név` = Felhasználó által választott új név `E-mail` = Felhasználó által választott új email.
- **Művelet:** A `Mentés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A rendszer frissíti a felhasználó adatait abban az esetben, ha a felhasználó által választott új email cím még nincsen használatban. Végül az új név és email-cím megjelenik a Profil oldalon.

#### 2.11.2. TC-02
- **TP:** TP-11
- **Leírás:** Ebben a tesztesetben az input mezőket üresen hagyjuk, és megfigyeljük, hogy a rendszer hogyan reagál erre az esetre.
- **Bemenet:** `Név` = Üresen hagyjuk. `E-mail` = Üresen hagyjuk.
- **Művelet:** A `Mentés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A rendszer figyelmeztet, hogy minden mező kitöltése kötelező.

#### 2.11.3. TC-03
- **TP:** TP-11
- **Leírás:** A felhasználó megpróbálja olyan email-címet megadni, amely már egy másik felhasználóhoz tartozik.
- **Bemenet:** `Név` = Felhasználó által választott új név `E-mail` = Létező másik felhasználó regisztrált email-címe.
- **Művelet:** A `Mentés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A rendszer figyelmezteti a felhasználót, hogy a megadott email-cím már használatban van.

#### 2.11.4. TC-04
- **TP:** TP-11
- **Leírás:** A felhasználó csak a felhasználónevet változtatja meg, az email-címet változatlanul hagyja.
- **Bemenet:** `Név` = Felhasználó által választott új név `E-mail` = Korábbi regisztrált email-cím.
- **Művelet:** A `Mentés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A rendszer frissíti a felhasználó nevét, az email-címet változatlanul hagyva. Az új név megjelenik a Profil oldalon.

#### 2.11.5. TC-05
- **TP:** TP-11
- **Leírás:** A felhasználó az email-címet hagyja üresen, de megpróbálja megváltoztatni a nevét.
- **Bemenet:** `Név` = Felhasználó által választott új név `E-mail` = Üresen hagyjuk.
- **Művelet:** A `Mentés` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A rendszer figyelmezteti a felhasználót, hogy a kötelező mezőt (e-mail cím) ki kell tölteni.

### 2.12. Jelszó módosítás

#### 2.12.1. TC-01
- **TP:** TP-12
- **Leírás:** Helyes adatokat adunk meg minden mezőben. A folyamat sikerességét az jelzi, ha a profil oldalon találjuk magunkat, nem kapunk hibaüzenetet..
- **Bemenet:** `Jelenlegi jelszó` = Regisztrációkor megadott vagy azóta módosított jelenleg érvényes jelszavunk. `Új jelszó` = A jelszónak legalább négy karakterből kell állnia. `Jelszó megerősítése` = A jelszónak legalább négy karakterből kell állnia és egyeznie kell az új jelszóval.
- **Művelet:** A `Jelszó változtatása` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az alkalmazás a profil oldalra navigál.

#### 2.12.2. TC-02
- **TP:** TP-12
- **Leírás:** Ebben a tesztesetben az input mezőket üresen hagyjuk, és megfigyeljük, hogy a rendszer hogyan reagál erre az esetre.
- **Bemenet:** `Jelenlegi jelszó` = Üresen hagyjuk. `Új jelszó` = Üresen hagyjuk. `Jelszó megerősítése` = Üresen hagyjuk.
- **Művelet:** A `Jelszó változtatása` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A rendszer figyelmeztet, hogy minden mező kitöltése kötelező.

#### 2.12.3. TC-03
- **TP:** TP-12
- **Leírás:** Olyan jelenlegi jelszót adunk meg, amely nincs használatban.
- **Bemenet:** `Jelenlegi jelszó` = Tetszőleges bemenet. `Új jelszó` = A jelszónak legalább négy karakterből kell állnia. `Jelszó megerősítése` = A jelszónak legalább négy karakterből kell állnia és egyeznie kell az új jelszóval.
- **Művelet:** A `Jelszó változtatása` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az alkalmazás figyelmeztet, hogy a megadott jelszó helytelen.

#### 2.12.4. TC-04
- **TP:** TP-12
- **Leírás:** A felhasználó ugyanazt az új jelszót adja meg, amely már a jelenlegi jelszója.
- **Bemenet:** `Jelenlegi jelszó` = Jelenlegi érvényes jelszó. `Új jelszó` = Jelenlegi érvényes jelszó. `Jelszó megerősítése` = Jelenlegi érvényes jelszó.
- **Művelet:** A `Jelszó változtatása` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** A rendszer figyelmeztet, hogy az új jelszó nem lehet ugyanaz, mint a jelenlegi jelszó.

#### 2.12.5. TC-05
- **TP:** TP-12
- **Leírás:** A felhasználó olyan új jelszót ad meg, amely nem felel meg az elvárásoknak.
- **Bemenet:** `Jelenlegi jelszó` = Jelenlegi érvényes jelszó. `Új jelszó` = Csak három karakter hosszú jelszó. `Jelszó megerősítése` = Csak három karakter hosszú jelszó.
- **Művelet:** A `Jelszó változtatása` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az alkalmazás figyelmeztet, hogy az új jelszó nem felel meg a minimális karakterhossz elvárásának és nem egyezik meg a megerősítéssel.

#### 2.12.6. TC-06
- **TP:** TP-12
- **Leírás:** A felhasználó olyan megerősítő jelszót ad meg, amely nem egyezik az újonnan megadottal.
- **Bemenet:** `Jelenlegi jelszó` = Jelenlegi érvényes jelszó. `Új jelszó` = A jelszónak legalább négy karakterből kell állnia. `Jelszó megerősítése` = Tetszőleges bemenet.
- **Művelet:** A `Jelszó változtatása` gomb megnyomásával elküldjük a formot.
- **Elvárt kimenet:** Az alkalmazás figyelmeztet, hogy az új jelszó és annak megerősítésére szolgáló jelszó nem azonos. 

### 2.13. Jogosultságellenőrés

#### 2.13.1. TC-01
- **TP:** TP-13
- **Bemenet:** A /admin oldal elérése, bejelentkezett, "Felhasználó" jogosultságú fiókkal.
- **Elvárt kimenet:** Átirányítás a hiba oldalra, "Ehhez nincs jogosultságod" hibaüzenettel.

#### 2.13.2. TC-02
- **TP:** TP-13
- **Bemenet:** A /booking oldal elérése, bejelentkezett, "Felhasználó" jogosultságú fiókkal.
- **Elvárt kimenet:** Az időpontfoglaló felület megjelenítése.

#### 2.13.2. TC-03
- **TP:** TP-13
- **Bemenet:** A /admin/appointments oldal elérése, bejelentkezett, "Admin" jogosultságú fiókkal.
- **Elvárt kimenet:** Az adminfelületen belül az időpontok szerkesztésére szolgáló felület megjelenítése.

## 3. Tesztriportok (TR)

### 3.1. Regisztráció

#### 3.1.1. TR-01 (TC-01)
- **TP:** TP-2
    1. lépés: A `Név` mező bemenete: 'Adam'
    2. lépés: Az `E-mail` mező bemenete: 'adam@adam.hu'
    3. lépés: A `Jelszó` mező bemenete: 'adam'
    4. lépés: A `Regisztráció` gombot megnyomtam.
    5. lépés: Az alkalmazás a kezdőlapra navigált, ahol a munkamenet elkezdődött.

#### 3.1.2. TR-02 (TC-02)
- **TP:** TP-2
    1. lépés: A `Név` mező bemenete: ''
    2. lépés: Az `E-mail` mező bemenete: ''
    3. lépés: A `Jelszó` mező bemenete: ''
    4. lépés: A `Regisztráció` gombot megnyomtam.
    5. lépés: A regisztráció sikertelen, továbbá az alkalmazás jelezte, hogy az e-mail megadása kötelező.

#### 3.1.3. TR-02 (TC-03)
- **TP:** TP-2
    1. lépés: A `Név` mező bemenete: 'kiscica'
    2. lépés: Az `E-mail` mező bemenete: 'adam@adam.hu'
    3. lépés: A `Jelszó` mező bemenete: 'kiscica12'
    4. lépés: A `Regisztráció` gombot megnyomtam.
    5. lépés: A regisztráció sikertelen, továbbá az alkalmazás jelezte, hogy a megadott email-cím már használatban van.

### 3.2. Bejelentkezés

#### 3.2.1. TR-01(TC-01)
- **TP:** TP-02
    1. lépés: Létező regisztrált email-címet adtam meg.
    2. lépés: A regisztráció során megadott jelszót adtam meg.
    3. lépés: A Bejelentkezés gombot egyszer megnyomtam.
    4. lépés: Az alkalmazás a főoldalra navigált.
    5. lépés: A munkamenet sikeresen elindult.

#### 3.2.2. TR-02(TC-02)
- **TP:** TP-02
    1. lépés: Mindkét input mezőt üresen hagytam.
    2. lépés: A Bejelentkezés gombot egyszer megnyomtam.
    3. lépés: A rendszer figyelmeztetést adott ki a kötelező mezőkről.

#### 3.2.3. TR-03(TC-03)
- **TP:** TP-02
    1. lépés: Létező regisztrált email-címet adtam meg.
    2. lépés: Helytelen jelszót adtam meg.
    3. lépés: A Bejelentkezés gombot egyszer megnyomtam.
    4. lépés: Az alkalmazás jelzi, hogy a bejelentkezés sikertelen volt.

#### 3.2.4. TR-04(TC-04)
- **TP:** TP-02
    1. lépés: Létező regisztrált email-címet adtam meg.
    2. lépés: A jelszó mezőt üresen hagytam.
    3. lépés: A Bejelentkezés gombot egyszer megnyomtam.
    4. lépés: A rendszer figyelmeztetést adott ki a kötelező mezőkről.

#### 3.2.5. TR-05(TC-05)
- **TP:** TP-02
    1. lépés: Nem regisztrált email-címet adtam meg.
    2. lépés: Bármilyen jelszót adtam meg.
    3. lépés: A Bejelentkezés gombot egyszer megnyomtam.
    4. lépés: Az alkalmazás jelzi, hogy a megadott e-mail cím nem regisztrált.

### 3.3. Kijelentkezés

#### 3.3.1. TR-01(TC-01)
- **TP:** TP-02
    1. lépés: Belépünk átlag felhasználói fiókkal.
    2. lépés: Rávisszük az egeret a profil fülre.
    3. lépés: A Kijelentkezés gombot egyszer megnyomtam.
    4. lépés: Az alkalmazás a főoldalra navigált.
    5. lépés: A munkamenet sikeresen bezárt.

#### 3.3.2. TR-02(TC-02)
- **TP:** TP-02
    1. lépés: Belépünk admin fiókkal.
    2. lépés: Rávisszük az egeret a profil fülre.
    3. lépés: A Kijelentkezés gombot egyszer megnyomtam.
    4. lépés: Az alkalmazás a főoldalra navigált.
    5. lépés: A munkamenet sikeresen bezárt.

#### 3.3.3. TR-03(TC-03)
- **TP:** TP-02
    1. lépés: Belépünk admin fiókkal.
    2. lépés: Rávisszük az egeret a profil fülre.
    3. lépés: Felmérések oldalra átlépünk.
    4. lépés: A Kijelentkezés gombot egyszer megnyomtam.
    5. lépés: Az alkalmazás a főoldalra navigált.
    6. lépés: A munkamenet sikeresen bezárt.

### 3.3. Biztonsági mentés készítése

#### 3.3.1. TR-01(TC-01)
- **TP:** TP-02
    1. lépés: Megvártuk, hogy elérkezzen az automatikus biztonsági mentés ideje, amely 03:10-kor történt meg.
    2. lépés: A biztonsági mentési mappában időbélyegzett JSON fájlokban megtalálhatók az összes adat.

### 3.5. Felhasználó törlése (Admin oldal)

#### 3.5.1. TR-01(TC-01)
- **TP:** TP-05
    1. lépés: Belépünk Admin felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Admin nevű fülére, majd a `Felhasználók` gombra.
    3. lépés: A kilistázott felhasználók közül kiválasztunk egyet.
    4. lépés: Töröljük a `Töröl` gombbal.
    5. lépés: Az oldal frissül, és a felhasználó eltűnik a törölhető felhasználók közül.

#### 3.5.2. TR-02(TC-02)
- **TP:** TP-05
    1. lépés: Belépünk Admin felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Admin nevű fülére, majd a `Felhasználók` gombra.
    3. lépés: A kilistázott felhasználók közül kiválasztunk egyet.
    4. lépés: Töröljük a `Töröl` gombbal.
    5. lépés: Megpróbálunk bejelentkezni a törölt felhasználó adataival.
    6. lépés: A bejelentkezés sikertelen. 


### 3.6. Időpont Hozzáadás

#### 3.6.1. TR-01(TC-01)
- **TP:** TP-06
    1. lépés: Belépünk Admin felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Profil nevű fülére, majd az `Időpontok szerkesztése` gombra.
    3. lépés: Az Időpont Hozzáadása legördülő menüből kiválasztunk egy kivánt időpontot.
    4. lépés: Rákattintunk az `Időpont hozzáadás` gombra.
    5. lépés: A időpont sikeresen felvive és megjelenik a Módositó listában is.

#### 3.6.2. TR-02(TC-02)
- **TP:** TP-06
    1. lépés: Belépünk Admin felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Profil nevű fülére, majd az `Időpontok szerkesztése` gombra.
    3. lépés: Az Időpont Hozzáadása legördülő menüből kiválasztunk egy kivánt időpontot.
    4. lépés: Hozzáadjuk.
    5. lépés: Átjelentkezünk egy Felhasználói fiókra.
    6. lépés: Rémegyünk az `Időpontfoglalás` fülre.
    7. lépés: A felvitt időpont sikeresen megjelenik a Felhasználók időpontfoglalási legördülő menüben.

#### 3.6.3. TR-03(TC-03)
- **TP:** TP-06
    1. lépés: Belépünk Admin felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Profil nevű fülére, majd az `Időpontok szerkesztése` gombra.
    3. lépés: Az Időpont Hozzáadása legördülő menüből kiválasztunk egy kivánt időpontot.
    4. lépés: Rákattintunk az `Időpont hozzáadás` gombra.
    5. lépés: A időpont sikeresen felvive és megjelenik a Törlés listában is.


### 3.7. Időpont Módositó

#### 3.7.1. TR-01(TC-01)
- **TP:** TP-07
    1. lépés: Belépünk Admin felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Profil nevű fülére, majd az `Időpontok szerkesztése` gombra.
    3. lépés: Az Időpont Módosítása legördülő menüből kiválasztunk egy kivánt időpontot és változtatunk rajta.
    4. lépés: Rákattintunk az `Időpont Módosítása` gombra.
    5. lépés: A időpont sikeresen módosítva és megjelenik a módositó listában is.

#### 3.7.2. TR-02(TC-02)
- **TP:** TP-07
    1. lépés: Belépünk Admin felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Profil nevű fülére, majd az `Időpontok szerkesztése` gombra.
    3. lépés: Az Időpont Módosítása legördülő menüből kiválasztunk egy kivánt időpontot és változtatunk rajta.
    4. lépés: Rákattintunk az `Időpont Módosítása` gombra.
    5. lépés: A időpont sikeresen módosítva és megjelenik a törlés listában is.

#### 3.7.2. TR-02(TC-02)
- **TP:** TP-07
    1. lépés: Belépünk Admin felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Profil nevű fülére, majd az `Időpontok szerkesztése` gombra.
    3. lépés: Az Időpont Módosítása legördülő menüből kiválasztunk egy kivánt időpontot.
    4. lépés: Változtatunk rajta, rákattintunk az `Időpont Módosítása` gombra.
    5. lépés: Átjelentkezünk egy Felhasználói fiókra.
    6. lépés: Rémegyünk az `Időpontfoglalás` fülre.
    7. lépés: A módosított időpont sikeresen megjelenik a Felhasználók időpontfoglalási legördülő menüben.

### 3.8. Időpont Törlése(Admin oldal)

#### 3.8.1. TR-01(TC-01)
- **TP:** TP-08
    1. lépés: Belépünk Admin felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Admin nevű fülére, majd az `Időpontok szerkesztése` gombra.
    3. lépés: Az Időpont Törlése résznél  kiválasztunk egy kívánt időpontot.
    4. lépés: Rákattintunk az `Időpont törlése` gombra.
    5. lépés: Az oldal frissül, és az időpont eltűnik a módosítható időpontok közül.

#### 3.8.2. TR-02(TC-02)
- **TP:** TP-08
    1. lépés: Belépünk Admin felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Admin nevű fülére, majd az `Időpontok szerkesztése` gombra.
    3. lépés: Az Időpont Törlése résznél  kiválasztunk egy kívánt időpontot.
    4. lépés: Rákattintunk az `Időpont törlése` gombra.
    5. lépés: Az oldal frissül, és az időpont eltűnik a törölhető időpontok közül.

#### 3.8.3. TR-03(TC-03)
- **TP:** TP-08
    1.	lépés: Belépünk Admin felhasználói fiókkal.
    2.	lépés: Rámegyünk Időpontok szerkesztése gombra.
    3.	lépés: Az Időpont Törlése résznél kiválasztunk egy kívánt időpontot.
    4.	lépés: Töröljük.
    5.	lépés: Átjelentkezünk egy Felhasználói fiókba.
    6.	lépés: Rémegyünk az `Időpontfoglalás` fülre.
    7.	lépés: A felvitt időpont sikeresen eltűnik a legördülő menüből.

### 3.9. Időpont Módositó

#### 3.9.1. TR-01(TC-01)
- **TP:** TP-09
    1. lépés: Belépünk Felhasználói profillal.
    2. lépés: Rámegyünk az időpontfoglalás menüpontra.
    3. lépés: Választunk egy időpontot alistából.
    4. lépés: Rákattintunk az `Időpont Foglalás` gombra.
    5. lépés: A időpont sikeresen lefoglalódik és megjelenik a foglaltak között.

#### 3.9.2. TR-02(TC-02)
- **TP:** TP-09
    1. lépés: Belépünk Felhasználói profillal.
    2. lépés: Rámegyünk az időpontfoglalás menüpontra.
    3. lépés: Választunk egy időpontot alistából.
    4. lépés: Rákattintunk az `Időpont Foglalás` gombra.
    5. lépés: Megnézzük eltűnik-e a kiválasztott Időpont a legördülő listából.

#### 3.9.3. TR-03(TC-03)
- **TP:** TP-09
    1. lépés: Belépünk Felhasználói profillal.
    2. lépés: Rámegyünk az időpontfoglalás menüpontra.
    3. lépés: Választunk egy időpontot alistából.
    4. lépés: Rákattintunk az `Időpont Foglalás` gombra.
    5. lépés: Átjelentkezünk az Admin fiókba.
    6. lépés: Megnézzük megjelenik-e az új foglalás az Admin számára.

### 3.10. Fiók törlése

#### 3.10.1. TR-01(TC-01)
- **TP:** TP-10
    1. lépés: Belépünk felhasználói fiókkal.
    2. lépés: Rámegyünk profil ikon felső Profil nevű fülére.
    3. lépés: Rákattintunk egyszer a Fiók törlése gombra.
    4. lépés: Az alkalmazás a főoldalra navigált.
    5. lépés: A fiók sikeresen törölve.

#### 3.10.2. TR-02(TC-02)
- **TP:** TP-10
    1. lépés: Belépünk felhasználói fiókkal.
    2. lépés: Átkattintunk a Felmérések oldalra.
    3. lépés: Rámegyünk profil ikon felső Profil nevű fülére.
    4. lépés: Rákattintunk egyszer a Fiók törlése gombra.
    5. lépés: Az alkalmazás a főoldalra navigált.
    6. lépés: A fiók sikeresen törölve.
#### 3.10.2. TR-02(TC-02)
- **TP:** TP-10
    1. lépés: Belépünk felhasználói fiókkal.
    2. lépés: Átkattintunk a Leckék oldalra.
    3. lépés: Rámegyünk profil ikon felső Profil nevű fülére.
    4. lépés: Rákattintunk egyszer a Fiók törlése gombra.
    5. lépés: Az alkalmazás a főoldalra navigált.
    6. lépés: A fiók sikeresen törölve.    

### 3.11. Név és email-cím módosítás

#### 3.11.1. TR-01(TC-01)
- **TP:** TP-11
    1. lépés: Felhasználó által választott új nevet adtam meg.
    2. lépés: Felhasználó által választott új email-címet adtam meg.
    3. lépés: A Mentés gombot egyszer megnyomtam.
    4. lépés: A rendszer frissítette a felhasználó adatait.
    5. lépés: Az új név és email-cím megjelent a Profil oldalon.

#### 3.11.2. TR-02(TC-02)
- **TP:** TP-11
    1. lépés: Mindkét input mezőt üresen hagytam.
    2. lépés: A Mentés gombot egyszer megnyomtam.
    3. lépés: A rendszer figyelmeztetést adott ki a kötelező mezőkről.

#### 3.11.3. TR-03(TC-03)
- **TP:** TP-11
    1. lépés: Felhasználó által választott új nevet adtam meg.
    2. lépés: Már létező másik felhasználó regisztrált email-címét adtam meg.
    3. lépés: A Mentés gombot egyszer megnyomtam.
    4. lépés: A rendszer figyelmeztett, hogy a megadott email-cím már használatban van.

#### 3.11.4. TR-04(TC-04)
- **TP:** TP-11
    1. lépés: Felhasználó által választott új nevet adtam meg.
    2. lépés: Az email-címet változatlanul hagytam.
    3. lépés: A Mentés gombot egyszer megnyomtam.
    4. lépés: A rendszer frissítette a felhasználó nevét.
    5. lépés: Az új név megjelent a Profil oldalon.

#### 3.11.5. TR-05(TC-05)
- **TP:** TP-11
    1. lépés: Felhasználó által választott új nevet adtam meg.
    2. lépés: Az email-címet üresen hagytam.
    3. lépés: A Mentés gombot egyszer megnyomtam.
    4. lépés: A rendszer figyelmeztetett, hogy a kötelező mezőt ki kell tölteni.

### 3.12. Jelszó módosítás

#### 3.12.1. TR-01 (TC-01)
- **TP:** TP-12
    1. lépés: 'csigabiga' jelszót adtam meg.
    2. lépés: 'cicamica' jelszót adtam meg.
    3. lépés: 'cicamica' jelszót adtam meg.
    4. lépés: a Jelszó módosítása gombot egyszer megnyomtam.
    5. lépés: az alkalmazás a profil oldalra navigált.

#### 3.12.2. TR-02 (TC-02)
- **TP:** TP-12
    1. lépés: '' jelszót adtam meg.
    2. lépés: '' jelszót adtam meg.
    3. lépés: '' jelszót adtam meg.
    4. lépés: a Jelszó módosítása gombot egyszer megnyomtam.
    5. lépés: az alkalmazás figyelmeztet arról, hogy minden mező kitöltése kötelező.

#### 3.12.3. TR-03 (TC-03)
- **TP:** TP-12
    1. lépés: 'nemcsigabiga' jelszót adtam meg.
    2. lépés: 'cicamica' jelszót adtam meg.
    3. lépés: 'cicamica' jelszót adtam meg.
    4. lépés: a Jelszó módosítása gombot egyszer megnyomtam.
    5. lépés: az alkalmazás figyelmeztet arról, hogy helytelen jelenlegi jelszót adtam meg.

#### 3.12.2. TR-04 (TC-04)
- **TP:** TP-12
    1. lépés: 'csigabiga' jelszót adtam meg.
    2. lépés: 'csigabiga' jelszót adtam meg.
    3. lépés: 'csigabiga' jelszót adtam meg.
    4. lépés: a Jelszó módosítása gombot egyszer megnyomtam.
    5. lépés: az alkalmazás figyelmeztet arról, hogy az új jelszó nem lehet ugyanaz, mint a jelenlegi.

#### 3.12.5. TR-05 (TC-05)
- **TP:** TP-12
    1. lépés: 'csigabiga' jelszót adtam meg.
    2. lépés: 'asd' jelszót adtam meg.
    3. lépés: 'asd' jelszót adtam meg.
    4. lépés: a Jelszó módosítása gombot egyszer megnyomtam.
    5. lépés: az alkalmazás figyelmeztet arról, hogy az új jelszó nem felel meg a minimális karakterhossz elvárásának.

#### 3.12.5. TR-06 (TC-06)
- **TP:** TP-12
    1. lépés: 'csigabiga' jelszót adtam meg.
    2. lépés: 'cicamica' jelszót adtam meg.
    3. lépés: 'cica' jelszót adtam meg.
    4. lépés: a Jelszó módosítása gombot egyszer megnyomtam.
    5. lépés: az alkalmazás figyelmeztet arról, hogy az új jelszó nem egyezik meg a megerősítéssel.

### 3.13. Jogosultságellenőrzés

#### 3.13.1. TR-01 (TC-01)
- **TP:** TP-13
    1. lépés: A /admin oldal elérése, bejelentkezett, "Felhasználó" jogosultságú fiókkal.
    2. lépés: Hibaoldal megjelenítése "Nincs ehhez jogosultságod" üzenettel.

#### 3.13.2. TR-02 (TC-02)
- **TP:** TP-13
    1. lépés: A /booking oldal elérése, bejelentkezett, "Felhasználó" jogosultságú fiókkal.
    2. lépés: Be vagyunk jelentkezve, van, eleget tesz a jogosultságunk, tehát az "időpont foglalása" oldal megjelítése.

#### 3.13.3. TR-03 (TC-03)
- **TP:** TP-13
    1. lépés: A /admin/appointments oldal elérése, bejelentkezett, "Admin" jogosultságú fiókkal.
    2. lépés: Be vagyunk jelentkezve, van, eleget tesz a jogosultságunk, tehát az "időpontok szerkesztése" oldal megjelítése.

