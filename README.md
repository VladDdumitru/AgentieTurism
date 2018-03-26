# AgentieTurism

In clasa Agency voi avea 4 hashtable-uri pentru a identifica usor un loc, oras, judet sau tara.
Astfel, cand trebuie sa gasesc de exemplu top5 orase dintr-un oras, nu trebuie sa parcurg toata ierarhia pentru a gasi orasul,
ci il gasesc direct in hashtable-ul respectiv.

Atunci cand generez datele (tari, judete, orase) pastrez in judet tara din care face parte, iar in oras judetul din care face parte, 
respectiv tara din care face parte pentru a putea gasi usor informatii despre unde se afla un loc. Astfel, atunci cand caut
un loc voi avea o legatura: loc->oras>judet->tara si voi putea gasi si alte informatii despre orasul, judetul sau tara din care face parte
locul.

Metoda generateFilesWithPlaces din main va crea un fisier cu date random cu locurile de vizitat. Pentru a adauga mai multe locuri
se poate modifica variabila N din clasa Main. De asemenea, pentru a adauga mai multe orase, tari si judete se poate modifica variabila
N din clasa Agency.
