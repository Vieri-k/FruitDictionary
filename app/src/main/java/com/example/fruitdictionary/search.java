package com.example.fruitdictionary;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class search extends Activity {
    private ListView lv;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
    ArrayList<HashMap<String, String>> buahku;


        // Data Array yang akan ditampilkan di list
        private static String[] buah = {"Apel",
                "Melon",
                "Semangka",
                "Pisang",
                "Manggis",
                "Jeruk",
                "Anggur",
                "Alpukat",
                "Nanas",
                "Durian",
                "Belimbing",
                "Ceri",
                "Duku",
                "Jambu air",
                "Jambu Biji",
                "Buah Kecapi",
                "Kedongdong",
                "Kelapa",
                "Lemon",
                "Mangga",
                "Buah Naga",
                "Pepaya",
                "Buah Pir",
                "Rambutan",
                "Salak",
                "Buah Sawo",
                "Sirsak",
                "Strawberry"};

        private static String[] detail_buah = {
                "Apel adalah jenis buah-buahan, atau buah yang dihasilkan dari pohon buah apel. Buah apel biasanya berwarna merah kulitnya jika masak dan (siap dimakan), namun bisa juga kulitnya berwarna hijau atau kuning. Kulit buahnya agak lembek, daging buahnya keras. Buah ini memiliki beberapa biji di dalamnya.\n" +
                        "\n" +
                        "Orang mulai pertama kali menanam apel di Asia Tengah. Kini apel berkembang di banyak daerah di dunia yang suhu udaranya lebih dingin. Nama ilmiah pohon apel dalam bahasa Latin ialah Malus domestica. Apel budidaya adalah keturunan dari Malus sieversii asal Asia Tengah, dengan sebagian genom dari Malus sylvestris (apel hutan/apel liar).\n" +
                        "\n" +
                        "Kebanyakan apel bagus dimakan mentah-mentah (tak dimasak), dan juga digunakan banyak jenis makanan pesta. Apel dimasak sampai lembek untuk dibuat saus apel. Apel juga dibuat untuk menjadi minuman sari buah apel.",
                "Melon (Cucumis melo L.) merupakan nama buah sekaligus tanaman yang menghasilkannya, yang termasuk dalam suku labu-labuan atau Cucurbitaceae. Buahnya biasanya dimakan segar sebagai buah meja atau diiris-iris sebagai campuran es buah. Bagian yang dimakan adalah daging buah (mesokarp). Teksturnya lunak, berwarna putih sampai merah, tergantung kultivarnya.",
                "Semangka atau tembikai (Citrullus lanatus, suku ketimun-ketimunan atau Cucurbitaceae) adalah tanaman merambat yang berasal dari daerah setengah gurun di Afrika bagian selatan. Tanaman ini masih sekerabat dengan labu-labuan (Cucurbitaceae), melon (Cucumis melo) dan ketimun (Cucumis sativus). Semangka biasa dipanen buahnya untuk dimakan segar atau dibuat jus. Biji semangka yang dikeringkan dan disangrai juga dapat dimakan isinya (kotiledon) sebagai kuaci.\n" +
                        "\n" +
                        "Sebagaimana anggota suku ketimun-ketimunan lainnya, habitus tanaman ini merambat namun ia tidak dapat membentuk akar adventif dan tidak dapat memanjat. Jangkauan rambatan dapat mencapai belasan meter.\n" +
                        "\n" +
                        "Daunnya berlekuk-lekuk di tepinya. Bunganya sempurna, berwarna kuning, kecil (diameter 3cm). Semangka adalah andromonoecious monoklin, yaitu memiliki dua jenis bunga pada satu tumbuhan: bunga jantan, yang hanya memiliki benang sari (stamen), dan bunga banci/hermafrodit, yang memiliki benang sari dan putik (pistillum). Bunga banci dapat dikenali dari adanya bakal buah (ovarium) di bagian pangkal bunga berupa pembesaran berbentuk oval.\n" +
                        "\n" +
                        "Buah semangka memiliki kulit yang keras, berwarna hijau pekat atau hijau muda dengan larik-larik hijau tua. Tergantung kultivarnya, daging buahnya yang berair berwarna merah atau kuning.\n" +
                        "\n" +
                        "Tanaman ini cukup tahan akan kekeringan terutama apabila telah memasuki masa pembentukan buah.",
                "Pisang adalah nama umum yang diberikan pada tumbuhan terna raksasa berdaun besar memanjang dari suku Musaceae. Beberapa jenisnya (Musa acuminata, M. balbisiana, dan M. ×paradisiaca) menghasilkan buah konsumsi yang dinamakan sama. Buah ini tersusun dalam tandan dengan kelompok-kelompok tersusun menjari yang disebut sisir. Hampir semua buah pisang memiliki kulit berwarna kuning ketika matang, meskipun ada beberapa yang berwarna jingga, merah, hijau, ungu, atau bahkan hampir hitam. Buah pisang sebagai bahan pangan merupakan sumber energi (karbohidrat) dan mineral, terutama kalium.\n" +
                        "\n" +
                        "Perlu disadari, istilah \"pisang\" juga dipakai untuk sejumlah jenis yang tidak menghasilkan buah konsumsi, seperti pisang abaka, pisang hias, dan pisang kipas. Artikel ini hanya membahas pisang penghasil buah konsumsi serta kerabatnya yang berkaitan.",
                "Manggis (Garcinia mangostana L.) adalah sejenis pohon hijau abadi dari daerah tropika yang diyakini berasal dari Semenanjung Malaya dan menyebar ke Kepulauan Nusantara. Tumbuh hingga mencapai 7 sampai 25 meter. Buahnya juga disebut manggis, berwarna merah keunguan ketika matang, meskipun ada pula varian yang kulitnya berwarna merah, Buah manggis dalam perdagangan dikenal sebagai \"ratu buah\", sebagai pasangan durian, si \"raja buah\". Buah ini mengandung mempunyai aktivitas antiinflamasi dan antioksidan. Sehingga di luar negeri buah manggis dikenal sebagai buah yang memiliki kadar antioksidan tertinggi di dunia.\n" +
                        "\n" +
                        "Manggis berkerabat dengan kokam, asam kandis dan asam gelugur, rempah bumbu dapur dari tradisi boga India dan Sumatra.",
                "Jeruk atau limau adalah semua tumbuhan berbunga anggota marga Citrus dari suku Rutaceae (suku jeruk-jerukan). Anggotanya berbentuk pohon dengan buah yang berdaging dengan rasa masam yang segar, meskipun banyak di antara anggotanya yang memiliki rasa manis. Rasa masam berasal dari kandungan asam sitrat yang memang menjadi terkandung pada semua anggotanya. Sebutan \"jeruk\" kadang-kadang juga disematkan pada beberapa anggota marga lain yang masih berkerabat dalam suku yang sama, seperti kingkit. Dalam bahasa sehari-hari, penyebutan \"jeruk\" atau \"limau\" (di Sumatra dan Malaysia) seringkali berarti \"jeruk keprok\" atau \"jeruk manis\". Di Jawa, \"limau\" (atau \"limo\") berarti \"jeruk nipis\".\n" +
                        "\n" +
                        "Jeruk sangatlah beragam dan beberapa spesies dapat saling bersilangan dan menghasilkan hibrida antarspesies ('interspecific hybrid) yang memiliki karakter yang khas, yang berbeda dari spesies tetuanya. Keanekaragaman ini seringkali menyulitkan klasifikasi, penamaan dan pengenalan terhadap anggota-anggotanya, karena orang baru dapat melihat perbedaan setelah bunga atau buahnya muncul. Akibatnya tidak diketahui dengan jelas berapa banyak jenisnya. Penelitian-penelitian terakhir menunjukkan adalah keterkaitan kuat Citrus dengan genus Fortunella (kumkuat), Poncirus, serta Microcitrus dan Eremocitrus, sehingga ada kemungkinan dilakukan penggabungan. Citrus sendiri memiliki dua anakmarga (subgenus), yaitu Citrus dan Papeda.\n" +
                        "\n" +
                        "Asal jeruk adalah dari Asia Timur dan Asia Tenggara, membentuk sebuah busur yang membentang dari Jepang terus ke selatan hingga kemudian membelok ke barat ke arah India bagian timur. Jeruk manis dan sitrun (lemon) berasal dari Asia Timur, sedangkan jeruk bali, jeruk nipis dan jeruk purut berasal dari Asia Tenggara.\n" +
                        "\n" +
                        "Banyak anggota jeruk yang dimanfaatkan oleh manusia sebagai bahan pangan, wewangian, maupun industri. Buah jeruk adalah sumber vitamin C dan wewangian/parfum penting. Daunnya juga digunakan sebagai rempah-rempah.",
                "Anggur merupakan tanaman buah berupa perdu merambat yang termasuk ke dalam keluarga Vitaceae. Buah ini biasanya digunakan untuk membuat jus anggur, jelly, minuman anggur, minyak biji anggur dan kismis, atau dimakan langsung. Buah ini juga dikenal karena mengandung banyak senyawa polifenol dan resveratol yang berperan aktif dalam berbagai metabolisme tubuh, serta mampu mencegah terbentuknya sel kanker dan berbagai penyakit lainnya.[2] Aktivitas ini juga terkait dengan adanya senyawa metabolit sekunder di dalam buah anggur yang berperan sebagai senyawa antioksidan yang mampu menangkal radikal bebas.[3][4]\n" +
                        "\n" +
                        "Tanaman ini sudah dibudidayakan sejak tahun 4000 SM di Timur Tengah.[1] Akan tetapi, proses pengolahan buah anggur menjadi minuman anggur baru ditemukan pada tahun 2500 SM oleh bangsa Mesir.[1] Hanya beberapa waktu berselang, proses pengolahan ini segera tersebar luas ke berbagai penjuru dunia, mulai dari daerah di Laut Hitam, Spanyol, Jerman, Prancis, dan Austria.[1] Penyebaran buah ini berkembang samakin pesat dengan adanya perjalanan Colombus yang membawa buah ini mengitari dunia.[1]",
                "Alpukat (Persea americana) ialah tumbuhan penghasil buah meja dengan nama sama. Tumbuhan ini berasal dari Meksiko dan Amerika Tengah dan kini banyak dibudidayakan di Amerika Selatan dan Amerika Tengah sebagai tanaman perkebunan monokultur dan sebagai tanaman pekarangan di daerah-daerah tropika lainnya di dunia.Pohon, dengan batang mencapai tinggi 20 m dengan daun sepanjang 12 hingga 25 cm. Bunganya tersembunyi dengan warna hijau kekuningan dan ukuran 5 hingga 10 milimeter. Ukurannya bervariasi dari 7 hingga 20 sentimeter, dengan massa 100 hingga 1000 gram; biji yang besar, 5 hingga 6,4 sentimeter.\n" +
                        "\n" +
                        "Buahnya bertipe buni, memiliki kulit lembut tak rata berwarna hijau tua hingga ungu kecoklatan, tergantung pada varietasnya. Daging buah apokat berwarna hijau muda dekat kulit dan kuning muda dekat biji, dengan tekstur lembut.",
                "Nanas, nenas, atau ananas (Ananas comosus (L.) Merr.) adalah sejenis tumbuhan tropis yang berasal dari Brasil, Bolivia, dan Paraguay Tumbuhan ini termasuk dalam familia nanas-nanasan (Famili Bromeliaceae). Perawakan (habitus) tumbuhannya rendah, herba (menahun) dengan 30 atau lebih daun yang panjang, berujung tajam, tersusun dalam bentuk roset mengelilingi batang yang tebal.  Buahnya dalam bahasa Inggris disebut sebagai pineapple karena bentuknya yang seperti pohon pinus. Nama 'nanas' berasal dari sebutan orang Tupi untuk buah ini: anana, yang bermakna \"buah yang sangat baik\". Burung penghisap madu (hummingbird) merupakan penyerbuk alamiah dari buah ini, meskipun berbagai serangga juga memiliki peran yang sama.\n" +
                        "\n" +
                        "Buah nanas sebagaimana yang dijual orang bukanlah buah sejati, melainkan gabungan buah-buah sejati (bekasnya terlihat dari setiap 'sisik' pada kulit buahnya) yang dalam perkembangannya tergabung—bersama-sama dengan tongkol (spadix) bunga majemuk—menjadi satu 'buah' besar. Nanas yang dibudidayakan orang sudah kehilangan kemampuan memperbanyak secara seksual, tetapi ia mengembangkan tanaman muda (bagian 'mahkota' buah) yang merupakan sarana perbanyakan secara vegetatif. nanas meningkatkan pencernaan dan mengurangi jerawat.[1] [1] Di Indonesia, provinsi Lampung merupakan daerah penanaman nanas utama, dengan beberapa pabrik pengolahan nanas juga terdapat di sana.",
                "Durian adalah nama tumbuhan tropis yang berasal dari wilayah Asia Tenggara, sekaligus nama buahnya yang bisa dimakan. Nama ini diambil dari ciri khas kulit buahnya yang keras dan berlekuk-lekuk tajam sehingga menyerupai duri. Sebutan populernya adalah \"raja dari segala buah\" (King of Fruit). Durian adalah buah yang kontroversial, meskipun banyak orang yang menyukainya, tetapi sebagian yang lain malah muak dengan aromanya.\n" +
                        "\n" +
                        "Sesungguhnya, tumbuhan dengan nama durian bukanlah spesies tunggal tetapi sekelompok tumbuhan dari marga Durio.[1] Namun, yang dimaksud dengan durian (tanpa imbuhan apa-apa) biasanya adalah Durio zibethinus. Jenis-jenis durian lain yang dapat dimakan dan kadangkala ditemukan di pasar tempatan di Asia Tenggara di antaranya adalah lai (D. kutejensis), kerantungan (D. oxleyanus), durian kura-kura atau kekura (D. graveolens), serta lahung (D. dulcis). Untuk selanjutnya, uraian di bawah ini mengacu kepada D. zibethinus.",
                "Belimbing / Belimbing Manis adalah tumbuhan penghasil buah berbentuk khas yang berasal dari Indonesia, India, dan Sri Langka. Saat ini, belimbing telah tersebar ke penjuru Asia Tenggara, Republik Dominika, Brasil, Peru, Ghana, Guyana, Tonga, dan Polinesia. Usaha penanaman secara komersial dilakukan di Amerika Serikat, yaitu di Florida Selatan dan Hawaii. Di Indonesia, buah ini menjadi ikon kota Depok, Jawa Barat, sejak tahun 2007.Buah belimbing berwarna kuning kehijauan. Saat baru tumbuh, buahnya berwarna hijau. Jika dipotong, buah ini mempunyai penampang yang berbentuk bintang. Berbiji kecil dan berwarna coklat. Buah ini renyah saat dimakan, rasanya manis dan sedikit asam. Buah ini mengandung banyak vitamin C.\n" +
                        "\n" +
                        "Salah satu jenis dari belimbing, yang disebut belimbing wuluh, sering digunakan untuk bumbu masakan, terutama untuk memberi rasa asam pada masakan.\n" +
                        "\n" +
                        "Salah satu wilayah yang terkenal akan produksi belimbing adalah Demak, Jawa Tengah. Belimbing Demak terkenal berukuran besar, warnaya kuning cerah dan rasanya manis.\n" +
                        "\n" +
                        "\n" +
                        "Belimbing\n",
                "Ceri adalah kelompok tumbuhan maupun buahnya anggota marga Prunus. Ceri tidak mencakup satu jenis saja, tetapi ada beberapa, seperti P. cerasus, P. avium, dan P. emarginata.\n" +
                        "\n" +
                        "Ceri adalah pohon yang sangat disukai di Jepang dan bunganya disebut sakura. Pada awal musim semi, di saat bunga ceri bermekaran, orang-orang berpiknik di taman-taman yang ditumbuhi pohon ini (Hanami). Di Australia ceri biasanya matang sekitar waktu Natal, sedangkan di Amerika dan Eropa selatan pada bulan Juni. Produksi di seluruh dunia saat ini tiga juta ton per tahun. Selain itu bunga dan buah ceri juga dijadikan hiasan hidangan makanan atau minuman. Buah ceri mengandung antosianin, yaitu pigmen warna merah yang baik untuk kesehatan karena merupakan antioksidan. Selain itu, rutin mengkonsumsi buah ceri setiap hari dapat menurunkan jumlah kadar asam urat dalam tubuh, bahkan dapat menyembuhkan pirai.",
                "Duku adalah jenis buah-buahan dari anggota suku Meliaceae. Tanaman yang berasal dari Asia Tenggara sebelah barat ini memiliki kemiripan dengan buah langsat, kokosan, pisitan, celoring dan lain-lain dengan pelbagai variasinya. Nama-nama yang beraneka ragam ini sekaligus menunjukkan adanya aneka kultivar yang tercermin dari bentuk buah dan pohon yang berbeda-beda.Duku amat bervariasi dalam sifat-sifat pohon dan buahnya; sehingga ada pula ahli yang memisah-misahkannya ke dalam jenis-jenis (spesies) yang berlainan. Pada garis besarnya, ada dua kelompok besar buah ini, yakni yang dikenal sebagai duku, dan yang dinamakan langsat. Kemudian ada kelompok campuran antara keduanya yang disebut duku-langsat, serta kelompok terakhir yang di Indonesia dikenal sebagai kokosan.[2]\n" +
                        "\n" +
                        "Kelompok yang dikenal sebagai duku (L. domesticum var. duku) umumnya memiliki pohon yang bertajuk besar, padat oleh dedaunan yang berwarna hijau cerah, dengan tandan yang relatif pendek dan berisi sedikit buah. Butiran buahnya besar, cenderung bulat, berkulit agak tebal namun cenderung tidak bergetah bila masak, umumnya berbiji kecil dan berdaging tebal, manis atau masam, dan berbau harum.[2][7]\n" +
                        "\n" +
                        "Langsat (L. domesticum var. domesticum) kebanyakan memiliki pohon yang lebih kurus, berdaun kurang lebat yang berwarna hijau tua, dengan percabangan tegak. Tandan buahnya panjang, padat berisi 15–25 butir buah yang berbentuk bulat telur dan besar-besar. Buah langsat berkulit tipis dan selalu bergetah (putih) sekalipun telah masak. Daging buahnya banyak berair, rasanya masam manis dan menyegarkan.[2][7] Tak seperti duku, langsat bukanlah buah yang bisa bertahan lama setelah dipetik. Dalam tiga hari setelah dipetik, kulit langsat akan menghitam sekalipun itu tidak merusak rasa manisnya. Hanya saja tampilannya menjadi tidak menarik.",
                "Jambu air adalah tumbuhan dalam suku jambu-jambuan atau Myrtaceae yang berasal dari Asia Tenggara. Jambu air sebetulnya berbeda dengan jambu semarang (Syzygium samarangense), kerabat dekatnya yang memiliki pohon dan buah hampir serupa. Beberapa kultivarnya bahkan sukar dibedakan, sehingga kedua-duanya kerap dinamai dengan nama umum jambu air atau jambu saja. Jambu air mudah ditanam dan di budidaya.\n" +
                        "\n" +
                        "Nama-nama lainnya adalah jambu ayer mawar (Malaysia), jambu aie (Min.), jambu cai (Sd.), jambu wer (Jw.), jhambhu wir (Md.), nyambu er (Bl.), kumpas, kumpasa, kombas, kembes (bahasa-bahasa di Sulut), jambu jene, jambu salo (Sulsel), jambu waelo, kuputol waelo, lutune waele, kopo olo (aneka bahasa di Seram dan sekitarnya), dan lain-lain.[1] Juga jambu kancing (Ind.), untuk kultivar yang buahnya kecil-kecil.[2]\n" +
                        "\n" +
                        "Di negara-negara lain, jambu ini dikenal sebagai machom phupa atau chomphu pa (Thai), tambis (Fil.), bell fruit, water apple (Ingg.) dan lain-lain.[3]",
                "Jambu batu (Psidium guajava) atau sering juga disebut jambu biji, jambu siki dan jambu klutuk adalah tanaman tropis yang berasal dari Brasil, disebarkan ke Indonesia melalui Thailand. Jambu batu memiliki buah yang berwarna hijau dengan daging buah berwarna putih atau merah dan berasa asam-manis. Buah jambu batu dikenal mengandung banyak vitamin C.",
                "Kecapi, sentul atau ketuat adalah nama sejenis buah dan juga pohon penghasilnya. Nama-nama lainnya adalah kechapi (Mal.), sentol, santol atau wild mangosteen (Ingg.), santor (Fil.) dan lain-lain. Nama ilmiahnya Sandoricum koetjape (Burm.f.) Merr. Pohon kecapi merupakan pohon yang rimbun dan besar, dapat mencapai tinggi 30 m, meski umumnya di pekarangan hanya mencapai sekitar 20-an meter. Batang dapat mencapai diameter 90 cm, bergetah seperti susu.\n" +
                        "\n" +
                        "Daun majemuk berselang-seling, bertangkai s/d 18 cm, menyirip beranak daun tiga, bentuk jorong sampai bundar telur, 6-26 × 3-16 cm; membulat atau agak runcing di pangkal, meruncing di ujung; hijau berkilat di sebelah atas, hijau kusam di bawahnya. Anak daun ujung bertangkai panjang, jauh lebih panjang dari tangkai anak daun sampingnya.\n" +
                        "\n" +
                        "Bunga dalam malai di ketiak daun, berambut, menggantung, sampai dengan 25 cm. Bunga berkelamin dua, bertangkai pendek; kelopak bertaju 5; mahkota 5 helai, kuning hijau, lanset sungsang, 6-8 mm; samar-samar berbau harum.\n" +
                        "\n" +
                        "Buah buni bulat agak gepeng, 5-6 cm, kuning atau kemerahan jika masak, berbulu halus seperti beludru. Daging buah bagian luar tebal dan keras, menyatu dengan kulit, kemerahan, agak masam; daging buah bagian dalam lunak dan berair, melekat pada biji, putih, masam sampai manis. Biji 2-5 butir, besar, bulat telur agak pipih, coklat kemerahan berkilat; keping biji berwarna merah.",
                "Kedondong adalah tanaman buah yang tergolong ke dalam suku mangga-manggaan (Anacardiaceae). Kedondong ini merupakan tanaman buah yang umumnya banyak sekali terdapat di seluruh daerah tropis dan termasuk kedalam angiospermae. Biasanya dalam bahasa inggris menyebutnya dengan Ambarella, Ataheitte apple / Great hot plum. Dalam setiap Negara maupun daerah, nama buah ini berbeda beda, seperti di asia tenggara biasa disebut: Kedondong (Indonesia & Malaysia), Hevi (Filiphina), Gway (Myanmar), Mokah (Kamboja), Kook kvan (Laos), Makak sarang (Thailand), Co’c (Vietnam). Selain itu kedondong juga disebut Kadendong (Sunda), Kedondong (Jawa), Kedundung (Madura),Kacemcem (Bali), Inci (NTT), Karuntung (Makassar), Dau Kaci (Bugis).\n" +
                        "\n" +
                        "Kedondong Bangkok merupakan jenis unggul yang biasa di tanam para petani. Selain ini jenis kedondong unggul lainnya adalah kedondong Konden di Karimun Jawa. Saat ini sudah banyak budi daya tanaman kedondong Bangkok untuk di jadikan tanaman buah dalam pot.Buah kedondong dapat dimakan langsung dalam kondisi segar, atau sering pula diolah menjadi rujak, asinan, acar atau dijadikan selai. Buah ini memiliki biji tunggal yang berserabut. Daun dijadikan penyedap dalam pembuatan pepes ikan.\n" +
                        "\n" +
                        "Batang pohon kedondong memiliki karakteristik berkulit tebal dan mudah patah. Pupus daun dan kedondong muda mempunyai rasa asam sehingga sering dijadikan sayuran atau penyedap masakan bagi orang jawa.",
                "Kelapa (Cocos nucifera) adalah anggota tunggal dalam marga Cocos dari suku aren-arenan atau Arecaceae.[1] Arti kata kelapa (atau coconut, dalam bahasa Inggris)[2] dapat merujuk pada keseluruhan pohon kelapa, biji, atau buah, yang secara botani adalah pohon berbuah, bukan pohon kacang-kacangan. Istilah ini berasal dari kata Portugis dan Spanyol abad ke-16, coco yang berarti \"kepala\" atau \"tengkorak\" setelah tiga lekukan pada tempurung kelapa yang menyerupai fitur wajah. Tumbuhan ini dimanfaatkan hampir semua bagiannya oleh manusia sehingga dianggap sebagai tumbuhan serbaguna, terutama bagi masyarakat pesisir. Kelapa juga adalah sebutan untuk buah yang dihasilkan tumbuhan ini.[3]\n" +
                        "\n" +
                        "Kelapa dikenal karena kegunaannya yang beragam, mulai dari makanan hingga kosmetik.[4] Daging bagian dalam dari benih matang membentuk bagian yang secara teratur menjadi sumber makanan bagi banyak orang di daerah tropis dan subtropis. Kelapa berbeda dari buah-buahan lain karena endosperma mereka mengandung sejumlah besar cairan bening,[4] disebut \"santan\" dalam literatur,[5] dan ketika belum matang, dapat dipanen untuk diminum sebagai \"air kelapa\", atau juga disebut \"jus kelapa\".\n" +
                        "\n" +
                        "Tumbuhan ini diperkirakan berasal dari pesisir Samudera Hindia di sisi Asia, tetapi kini telah menyebar luas di seluruh pantai tropika dunia.\n" +
                        "\n",
                "Sitrun, jeruk sitrun (dari bahasa Belanda, citroen), atau lemon adalah sejenis jeruk yang buahnya biasa dipakai sebagai penyedap dan penyegar dalam banyak seni boga dunia.\n" +
                        "\n" +
                        "Pohon berukuran sedang ini dapat mencapai 6 m dan tumbuh di daerah beriklim tropis dan sub-tropis serta tidak tahan akan cuaca dingin. Sitrun dibudidayakan di Spanyol, Portugal, Argentina, Brasil, Amerika Serikat dan negara-negara lainnya di sekitar Laut Tengah. Tumbuhan ini cocok untuk daerah beriklim kering dengan musim dingin yang relatif hangat. Suhu ideal untuk sitrun agar dapat tumbuh dengan baik adalah antara 15-30 °C (60-85 °F).\n" +
                        "\n" +
                        "Beberapa kultivarnya antara lain 'Eureka', 'Lisbon' dan 'Meyer'.",
                "Mangga atau mempelam adalah nama sejenis buah, demikian pula nama pohonnya. Mangga termasuk ke dalam marga Mangifera, yang terdiri dari 35-40 anggota dan suku Anacardiaceae. Pohon mangga termasuk tumbuhan tingkat tinggi yang struktur batangnya (habitus) termasuk kelompok arboreus, yaitu tumbuhan berkayu yang mempunyai tinggi batang lebih dari 5 m. Mangga bisa mencapai tinggi antara 10 hingga 40 m.\n" +
                        "\n" +
                        "Nama \"mangga\" berasal dari bahasa Malayalam maanga. Kata ini dibawa ke Eropa oleh orang-orang Portugis dan diserap menjadi manga (bahasa Portugis), mango (bahasa Inggris) dan lain-lain.\n" +
                        "\n" +
                        "Berasal dari daerah di sekitar perbatasan India dengan Burma, mangga telah menyebar ke Asia Tenggara sekurang-kurangnya semenjak 1500 tahun yang silam. Buah ini dikenal pula dalam berbagai bahasa daerah, seperti pelem atau poh (Jw.).",
                "Buah naga (Inggris: Pitaya) adalah buah dari beberapa jenis kaktus dari marga Hylocereus dan Selenicereus. Buah ini berasal dari Meksiko, Amerika Tengah dan Amerika Selatan namun sekarang juga dibudidayakan di negara-negara Asia seperti Taiwan, Vietnam, Filipina, Indonesia dan Malaysia. Buah ini juga dapat ditemui di Okinawa, Israel, Australia utara dan Tiongkok selatan. Hylocereus hanya mekar pada malam hari.\n" +
                        "\n" +
                        "Pada tahun 1870 tanaman ini dibawa orang Prancis dari Guyana ke Vietnam sebagai tanaman hias. Oleh orang Vietnam dan orang Cina buahnya dianggap membawa berkah. Oleh sebab itu, buah ini selalu diletakkan di antara dua ekor patung naga berwarna hijau di atas meja altar. Warna merah buah terlihat mencolok di antara warna naga-naga yang hijau. Kebiasaan inilah yang membuat buah tersebut di kalangan orang Vietnam yang sangat terpengaruh budaya Cina dikenal sebagai Thang Loy (Buah Naga). Istilah Thang Loy kemudian diterjemahkan di Eropa dan negara lain yang berbahasa Inggris sebagai Dragon Fruit (Buah Naga).",
                "Pepaya (Carica papaya L.), atau betik adalah tumbuhan yang berasal dari Meksiko bagian selatan dan bagian utara dari Amerika Selatan, dan kini menyebar luas dan banyak ditanam di seluruh daerah tropis untuk diambil buahnya. C. papaya adalah satu-satunya jenis dalam genus Carica. Nama pepaya dalam bahasa Indonesia diambil dari bahasa Belanda, \"papaja\", yang pada gilirannya juga mengambil dari nama bahasa Arawak, \"papaya\". Dalam bahasa Jawa pepaya disebut \"katès\" dan dalam bahasa Sunda \"gedang\".",
                "Pir (bahasa Inggris:pear) adalah sebutan untuk pohon dari genus Pyrus dan buah yang dihasilkan. Beberapa spesies pohon pir menghasilkan buah yang enak dimakan karena mengandung banyak air, masir dan manis. Pear adalah nama dalam bahasa Inggris. Pir adalah pohon yang berasal dari daerah beriklim tropis di Eropa Barat, Asia dan Afrika Utara. Pohon berketinggian sedang, bisa mencapai 10-17 meter tapi sebagian spesies merupakan pohon yang pendek yang memiliki daun yang rimbun.\n" +
                        "\n" +
                        "Daun berselang-seling, berbentuk lonjong yang lebar tapi bisa juga berbentuk membujur panjang (lanceolate) yang langsing. Panjang antara 2 sampai 12 cm. Pada sebagian spesies, daun berwarna hijau mengkilat atau sedikit berbulu berwarna keperakan. Sebagian besar pohon merontokkan daunnya di musim dingin (deciduous) dengan perkecualian dua spesies Pir di Asia Tenggara selalu berdaun hijau sepanjang tahun (evergreen).\n" +
                        "\n" +
                        "Pohon sangat tahan cuaca membeku di musim dingin hingga −25 °C and −40 °C kecuali spesies yang selalu berdaun hijau hanya tahan dingin sampai −15 °C.\n" +
                        "\n" +
                        "Bunga mekar di sekitar bulan April, berwarna putih dengan sedikit aksen warna kuning atau merah jambu. Bunga terdiri dari 5 daun mahkota. Diameter bunga antara 2 sampai 4 cm. Buah bertipe buah pome dengan diameter 1-4 cm pada spesies liar, sedangkan pohon hasil budidaya menghasilkan buah pir berukuran besar dengan ukuran sampai 18 × 8 cm. Bentuk buah beraneka ragam, sebagian besar spesies menghasilkan buah berbentuk bulat. Sebagian spesies seperti Pir Eropa menghasilkan buah yang bentuknya membesar di bagian bawah dan langsing di bagian pangkal buah. Buah siap panen di awal musim gugur.",
                "Rambutan adalah tanaman tropis yang tergolong ke dalam suku lerak-lerakan atau Sapindaceae, berasal dari daerah di Asia Tenggara. Kata \"rambutan\" berasal dari bentuk buahnya yang mempunyai kulit menyerupai rambut.\n" +
                        "\n" +
                        "Rambutan banyak terdapat di daerah tropis seperti Afrika, Kamboja, Karibia, Amerika Tengah, India, Indonesia, Malaysia, Filipina, Thailand dan Sri Lanka. Buah rambutan terbungkus oleh kulit yang memiliki \"rambut\" di bagian luarnya (eksokarp). Warnanya hijau ketika masih muda, lalu berangsur kuning hingga merah ketika masak/ranum. Endokarp berwarna putih, menutupi \"daging\". Bagian buah yang dimakan, \"daging buah\", sebenarnya adalah salut biji atau aril, yang bisa melekat kuat pada kulit terluar biji atau lepas (\"rambutan ace\"/ngelotok).\n" +
                        "\n" +
                        "Pohon dengan buah masak sangat menarik perhatian karena biasanya rambutan sangat banyak menghasilkan buah. Jika pertumbuhan musiman, buah masak pada bulan Desember hingga Maret, dikenal sebagai \"musim rambutan\". Masanya biasanya bersamaan dengan buah musiman lain, seperti durian dan mangga.",
                "Salak adalah sejenis palma dengan buah yang biasa dimakan. Ia dikenal juga sebagai sala (Min., Mak., Bug.,[1] dan Thai). Dalam bahasa Inggris disebut salak atau snake fruit, sementara nama ilmiahnya adalah Salacca zalacca. Buah ini disebut snake fruit karena kulitnya mirip dengan sisik ular. Salak terutama ditanam untuk dimanfaatkan buahnya, yang populer sebagai buah meja. Selain dimakan segar, salak juga biasa dibuat manisan, asinan, dikalengkan, atau dikemas sebagai keripik salak. Salak yang muda digunakan untuk bahan rujak. Umbut salak pun dapat dimakan.\n" +
                        "\n" +
                        "Helai-helai anak daun dan kulit tangkai daunnya dapat digunakan sebagai bahan anyaman, meski tentunya sesudah duri-durinya dihilangkan lebih dahulu.[3]\n" +
                        "\n" +
                        "Karena duri-durinya hampir tak tertembus, rumpun salak kerap ditanam sebagai pagar. Demikian pula, potongan-potongan tangkai daunnya yang telah mengering pun kerap digunakan untuk mempersenjatai pagar, atau untuk melindungi pohon yang tengah berbuah dari pencuri.\n" +
                        "\n" +
                        "Untuk pengobatan seperti untuk menghentikan diare, jadi bila kebanyakan makan salak akan menyebabkan kesulitan membuang air besar dalam kadar menengah. kadang kulit salak juga di gunakan dalam traditional china medicine/jamu sebagai bahan obat.[4][5]",
                "Sawo manila (Manilkara zapota) adalah pohon buah yang berumur panjang. Pohon dan buahnya dikenal dengan beberapa nama seperti sawo (Ind., Jw.), sauh atau sauh manila, atau ciku (Mly.).\n" +
                        "\n" +
                        "Nama-namanya dalam berbagai bahasa: tsiko (Filipina), ciku (Malaysia), chikoo atau sapota (India), sofeda (Bangladesh), xa pô chê atau hồng xiêm (Vietnam), rata-mi (Sri Lanka), lamoot (ละมุด) di Thailand, Laos dan Kamboja, níspero (Venezuela), sugardilly (Kep. Bahama), naseberry (Hindia Barat), sapote (Nicaragua), sapoti (Brasil), sapotillier (bahasa Prancis) dan sapodilla (bahasa Inggris).",
                "Sirsak, nangka belanda, atau durian belanda[2] (Annona muricata L.) adalah tumbuhan berguna yang berasal dari Karibia, Amerika Tengah dan Amerika Selatan. Di berbagai daerah Indonesia dikenal sebagai nangka sebrang, nangka landa (Jawa), nangka walanda, sirsak (Sunda), nangka buris, nangkelan (Madura), srikaya jawa (Bali), boh lôna (Aceh), durio ulondro (Nias), durian betawi (Minangkabau), serta jambu landa (di Lampung, \"Nangko Belando\" (Palembang). Penyebutan \"belanda\" dan variasinya menunjukkan bahwa sirsak (dari bahasa Belanda: zuurzak, berarti \"kantung asam\") didatangkan oleh pemerintah kolonial Hindia Belanda ke Nusantara, yaitu pada abad ke-19, meskipun bukan berasal dari Eropa.\n" +
                        "\n" +
                        "Tanaman ini ditanam secara komersial untuk diambil daging buahnya. Tumbuhan ini dapat tumbuh di sembarang tempat, paling baik ditanam di daerah yang cukup berair. Nama sirsak sendiri berasal dari bahasa Belanda. Zuurzak. yang berarti \"kantung yang asam\".\n" +
                        "\n" +
                        "Tanaman ini ditanam secara komersial atau sambilan untuk diambil buahnya. Pohon sirsak bisa mencapai tinggi 9 meter. Di Indonesia sirsak dapat tumbuh dengan baik pada ketinggian 1000 m dari permukaan laut.\n" +
                        "\n" +
                        "Buah sirsak bukan buah sejati, yang ukurannya cukup besar hingga 20–30 cm dengan berat mencapai 2,5 kg. Yang dinamakan \"buah\" sebenarnya adalah kumpulan buah-buah (buah agregat) dengan biji tunggal yang saling berhimpitan dan kehilangan batas antar buah. Daging buah sirsak berwarna putih dan memiliki biji berwarna hitam. Buah ini sering digunakan untuk bahan baku jus minuman serta es krim. Buah sirsak mengandung banyak karbohidrat, terutama fruktosa. Kandungan gizi lainnya adalah vitamin C, vitamin B1 dan vitamin B2 yang cukup banyak.[3] Bijinya beracun, dan dapat digunakan sebagai insektisida alami, sebagaimana biji srikaya.",
                "Stroberi atau tepatnya stroberi kebun (juga dikenal dengan nama arbei, dari bahasa Belanda aardbei) adalah sebuah varietas stroberi yang paling banyak dikenal di dunia. Seperti spesies lain dalam genus Fragaria (stroberi), buah ini berada dalam keluarga Rosaceae. Secara umum buah ini bukanlah buah, melainkan buah palsu,[1] artinya daging buahnya tidak berasal dari ovari tanaman (achenium) tetapi dari bagian bawah hypanthium yang berbentuk mangkok[2] tempat ovari tanaman itu berada.[3][4]\n" +
                        "\n" +
                        "\n" +
                        "Buah stroberi yang sudah masak\n" +
                        "Buah stroberi berwarna hijau keputihan ketika sedang berkembang, dan pada kebanyakan spesies berubah menjadi merah ketika masak. Namanya berasal dari bahasa Inggris kuno streawberige yang merupakan gabungan dari streaw atau \"straw\" dan berige atau \"berry\". Alasan pemberian nama ini masih tidak jelas. Beberapa spesies Lepidoptera mengambil sumber makanannya dari tumbuhan stroberi, menjadikan spesies ini hama utama tanaman stroberi."
        };
        private static int[] foto_buah = {
                R.drawable.apel,
                R.drawable.melon,
                R.drawable.semangka,
                R.drawable.pisang,
                R.drawable.manggis,
                R.drawable.jeruk,
                R.drawable.anggur,
                R.drawable.alpukat,
                R.drawable.nanas,
                R.drawable.durian,
                R.drawable.belimbing,
                R.drawable.ceri,
                R.drawable.duku,
                R.drawable.jambuair,
                R.drawable.jambubiji,
                R.drawable.buahkecapi,
                R.drawable.kedondong,
                R.drawable.kelapa,
                R.drawable.lemon,
                R.drawable.mangga,
                R.drawable.naga,
                R.drawable.pepaya,
                R.drawable.pir,
                R.drawable.rambutan,
                R.drawable.salak,
                R.drawable.sawo,
                R.drawable.sirsak,
                R.drawable.strawberry

        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        // ambil list_view dan inputsearchnya di xml
        lv = findViewById(R.id.list_view);
        inputSearch = findViewById(R.id.text_src);

        // proses menambahkan array kedalam listview
        adapter = new ArrayAdapter(this, R.layout.activity_search_filter,
                R.id.buah_name, buah);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), detail.class);
                intent.putExtra("nm_buah", buah[i]);
                intent.putExtra("dtl_buah", detail_buah[i]);
                intent.putExtra("ft_buah", foto_buah[i]);
                startActivity(intent);
            }
        });
        // Filter Seearch
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2,
                                      int arg3) {
                search.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });
    }
    private class lv extends BaseAdapter {
        @Override
        public int getCount() {
            return buah.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}
