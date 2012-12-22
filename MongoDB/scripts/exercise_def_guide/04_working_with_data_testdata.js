db.media.drop()

var book = ( { "Type": "Book",
    "Title": "Definite Guide to MongoDB, the",
    "ISBN": "987-1-4302-3051-9",
    "Publisher": "Apress",
    "Author": ["Membrey, Peter", "Plugge, Elco", "Hawkins, Tim"]
} );
db.media.insert(book);

/*Ähnlicher Einbtrag zum testen der distinct-Function*/
book = ( { "Type": "Book",
    "Title": "Definite Guide to MongoDB, the",
    "ISBN": "987-1-4302-3051-7",
    "Publisher": "Apress",
    "Author": ["Membrey, Peter", "Plugge, Elco", "Hawkins, Tim"]
} );

db.media.insert(book);

/*ab hier werden die Daten nur noch in der kurzen Form erfasst*/
db.media.insert({"Type": "CD", "Artist": "Nirvana", "Title": "Nevermind",
    "Tracklist": [
        {"Track": "1", "Title": "Smells like teen spirit", "Length": "5:02"},
        {"Track": "2", "Title": "In Bloom", "Length": "4:15"}
    ]
});

db.media.insert({"Type": "DVD", "Title": "Matrix, the", "Released": "1999",
    "Cast": [
        "Keanue Reeves", "Carry-Anne Moss", "Laurence Fishburne", "Hugo Weaving", "Gloria Foster", "Joe Pantoliano"
    ]})

