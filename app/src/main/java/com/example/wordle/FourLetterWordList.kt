package com.example.wordle

// author: calren
object FourLetterWordList {
    // List of most common 4 letter words from: https://7esl.com/4-letter-words/
    const val fourLetterWords =
        "Area,Army,Baby,Back,Ball,Band,Bank,Base,Bill,Body,Book,Call,Card,Care,Case,Cash,City,Club,Cost,Date,Deal,Door,Duty,East,Edge,Face,Fact,Farm,Fear,File,Film,Fire,Firm,Fish,Food,Foot,Form,Fund,Game,Girl,Goal,Gold,Hair,Half,Hall,Hand,Head,Help,Hill,Home,Hope,Hour,Idea,Jack,John,Kind,King,Lack,Lady,Land,Life,Line,List,Look,Lord,Loss,Love,Mark,Mary,Mind,Miss,Move,Name,Need,News,Note,Page,Pain,Pair,Park,Part,Past,Path,Paul,Plan,Play,Post,Race,Rain,Rate,Rest,Rise,Risk,Road,Rock,Role,Room,Rule,Sale,Seat,Shop,Show,Side,Sign,Site,Size,Skin,Sort,Star,Step,Task,Team,Term,Test,Text,Time,Tour,Town,Tree,Turn,Type,Unit,User,View,Wall,Week,West,Wife,Will,Wind,Wine,Wood,Word,Work,Year,Bear,Beat,Blow,Burn,Call,Care,Cast,Come,Cook,Cope,Cost,Dare,Deal,Deny,Draw,Drop,Earn,Face,Fail,Fall,Fear,Feel,Fill,Find,Form,Gain,Give,Grow,Hang,Hate,Have,Head,Hear,Help,Hide,Hold,Hope,Hurt,Join,Jump,Keep,Kill,Know,Land,Last,Lead,Lend,Lift,Like,Link,Live,Look,Lose,Love,Make,Mark,Meet,Mind,Miss,Move,Must,Name,Need,Note,Open,Pass,Pick,Plan,Play,Pray,Pull,Push,Read,Rely,Rest,Ride,Ring,Rise,Risk,Roll,Rule,Save,Seek,Seem,Sell,Send,Shed,Show,Shut,Sign,Sing,Slip,Sort,Stay,Step,Stop,Suit,Take,Talk,Tell,Tend,Test,Turn,Vary,View,Vote,Wait,Wake,Walk,Want,Warn,Wash,Wear,Will,Wish,Work,Able,Back,Bare,Bass,Blue,Bold,Busy,Calm,Cold,Cool,Damp,Dark,Dead,Deaf,Dear,Deep,Dual,Dull,Dumb,Easy,Evil,Fair,Fast,Fine,Firm,Flat,Fond,Foul,Free,Full,Glad,Good,Grey,Grim,Half,Hard,Head,High,Holy,Huge,Just,Keen,Kind,Last,Late,Lazy,Like,Live,Lone,Long,Loud,Main,Male,Mass,Mean,Mere,Mild,Nazi,Near,Neat,Next,Nice,Okay,Only,Open,Oral,Pale,Past,Pink,Poor,Pure,Rare,Real,Rear,Rich,Rude,Safe,Same,Sick,Slim,Slow,Soft,Sole,Sore,Sure,Tall,Then,Thin,Tidy,Tiny,Tory,Ugly,Vain,Vast,Very,Vice,Warm,Wary,Weak,Wide,Wild,Wise,Zero,Ably,Afar,Anew,Away,Back,Dead,Deep,Down,Duly,Easy,Else,Even,Ever,Fair,Fast,Flat,Full,Good,Half,Hard,Here,High,Home,Idly,Just,Late,Like,Live,Long,Loud,Much,Near,Nice,Okay,Once,Only,Over,Part,Past,Real,Slow,Solo,Soon,Sure,That,Then,This,Thus,Very,When,Wide"

    // Returns a list of four letter words as a list
    fun getAllFourLetterWords(): List<String> {
        return fourLetterWords.split(",")
    }

    // Returns a random four letter word from the list in all caps
    fun getRandomFourLetterWord(): String {
        val allWords = getAllFourLetterWords()
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }

    //Stretch feature: word lists
    //Word List: Animals
    const val fourLetterWordsAnimal =
        "Bass,Bear,Bird,Bull,Boar,Buck,Calf,Carp,Clam,Crab,Crow,Deer,Dodo,Dove,Duck,Fish,Flea,Frog,Gnat,Goat,Hare,Hawk,Ibex,Ibis,Kiwi,Lion,Mole,Moth,Mule,Mutt,Newt,Pike,Puma,Seal,Slug,Swan,Tick,Toad,Tuna,Wasp,Wolf,Worm,"
    fun getAllFourLetterWordsAnimal(): List<String> {
        return fourLetterWordsAnimal.split(",")
    }
    fun getRandomFourLetterWordAnimal(): String {
        val allWordsAnimal = getAllFourLetterWordsAnimal()
        val randomNumber = (0..allWordsAnimal.size).shuffled().last()
        return allWordsAnimal[randomNumber].uppercase()
    }
    //Word List: Names
    const val fourLetterWordsName =
        "Abby,Adam,Adan,Alan,Alex,Ally,Amir,Amos,Andi,Andy,Anna,Anne,Aria,Arlo,Aron,Asia,Axel,Ayla,Beau,Cade,Cain,Cian,Coby,Coco,Cody,Cole,Cora,Cory,Cruz,Dani,Dara,Dawn,Dean,Demi,Desi,Dior,Drew,Duke,Eden,Eila,Ella,Elly,Elon,Elsa,Emil,Emir,Emma,Emme,Emmy,Enzo,Erik,Evan,Ewan,Ezra,Fern,Finn,Ford,Fred,Gaia,Gary,Gian,Gino,Gray,Gwen,Hana,Hank,Hans,Hugo,Igor,Iris,Isha,Isla,Ivan,Iver,Jace,Jack,Jade,Jake,Jane,Jess,Joel,Joey,John,Jose,Juan,Jude,Judy,Juno,Kara,Kate,Kira,Kobe,Kobi,Koji,Kyla,Kyle,Lake,Lana,Lane,Lark,Leah,Leia,Lela,Lena,Leon,Levi,Lexi,Liam,Lila,Lily,Lina,Link,Lois,Lola,Lori,Luca,Lucy,Luis,Luka,Luke,Luna,Lyla,Lyle,Lyra,Macy,Mari,Mark,Mary,Maya,Mila,Milo,Mimi,Mylo,Myra,Nash,Nate,Naya,Neil,Nell,Niko,Nila,Noah,Noel,Nola,Noor,Nora,Nova,Odin,Olga,Omar,Opal,Orin,Otis,Otto,Owen,Ozzy,Paul,Raza,Reed,Remy,Rico,Rome,Rory,Rosa,Rose,Ruby,Ruth,Ryan,Sage,Sara,Saul,Sean,Seth,Shai,Shay,Skye,Tate,Theo,Thor,Tony,Tori,Troy,Vera,Wade,Yara,Zain,Zara,Zayd,Zeke,Zeus,Ziva,Zoey,Zora"
    fun getAllFourLetterWordsName(): List<String> {
        return fourLetterWordsName.split(",")
    }
    fun getRandomFourLetterWordName(): String {
        val allWordsName = getAllFourLetterWordsName()
        val randomNumber = (0..allWordsName.size).shuffled().last()
        return allWordsName[randomNumber].uppercase()
    }
    //Word List: Food
    const val fourLetterWordsFood =
        "bake,bean,beef,beet,boil,bowl,bran,buns,cake,chef,chew,chow,clam,cook,corn,crab,date,diet,dhal,dill,dine,dish,fast,feed,feta,fire,fish,flan,flax,food,fork,grub,gyro,hash,kale,kiwi,lamb,lard,leek,lime,loaf,meat,menu,milk,mint,nuts,nosh,oats,okra,oleo,oven,pate,pear,plum,pork,ribs,rice,roll,sage,salt,slaw,soda,sole,soup,sour,stew,suet,taco,taro,tart,tofu,tuna"
    fun getAllFourLetterWordsFood(): List<String> {
        return fourLetterWordsFood.split(",")
    }
    fun getRandomFourLetterWordFood(): String {
        val allWordsFood = getAllFourLetterWordsFood()
        val randomNumber = (0..allWordsFood.size).shuffled().last()
        return allWordsFood[randomNumber].uppercase()
    }
}
