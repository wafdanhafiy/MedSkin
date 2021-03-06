package com.protel.medskin.utils

import com.protel.medskin.data.skinsEntity
import com.protel.medskin.R

object dataDummy {

    fun generateDummySkins(): List<skinsEntity>{
        val skins = ArrayList<skinsEntity>()
        skins.add(skinsEntity(
            "AIDS",
            R.drawable.hiv,
            "Disebabkan oleh infeksi virus.",
            "Timbulnya ruam berbintik merah dengan benjolan kecil serta terasa gatal.",
            "Jika sudah terkena dapat menggunakan obat golongan antihistamin, dan jika sudah parah segera konsultasi ke dokter. kemudian jangan terkena paparan sinar matahari secara langsung dan jangan mandi air hangat.",
            79.33
        ))

        skins.add(skinsEntity(
            "Acne",
            R.drawable.jerawat,
            "Disebabkan oleh bakteri pada pori-pori kulit",
            "Gejala jerawat yaitu kulit berwarna merah dikarenakan bernanah, sensasi panas dikarenakan peradangan, dan rasa gatal",
            "Rajin menjaga kebersihan diri khususnya bagian muka.",
            79.33
        ))

        skins.add(skinsEntity(
            "Actinic Keratosis",
            R.drawable.actinic,
            "Disebabkan oleh paparan sinar ultraviolet yang berlebihan.",
            "Kulit terasa kasar, kering, dan bersisik dengan ukuran yang relatif kecil. pada bagian yang terinfeksi, berwarna merah kecoklatan serta terasa gatal atau sensasi terbakar.",
            "Untuk mengurangi terkenanya penyakit ini dapat dengan menghindari paparan ultraviolet secara langsung, dan jika sudah terkena dapat menggunakan obat yang dianjurkan oleh dokter, melakukan terapi, atau paling parah melakukan operasi.",
            79.33
        ))

        skins.add(skinsEntity(
            "Alopecia Areata",
            R.drawable.alopecia,
            "Disebabkan oleh sistem imun yang menyerang folikel rambut",
            "Rambut pada kepala mulai mengalami kebotakan dengan pola bulat yang dapat sementara atau permanen. dan jika semakin parah maka seluruh kepala akan mengalami kebotakan",
            "Untuk perawatan diri bisa memulai terapi dan memanajemen stres kita, serta dapa menggunakan obat untuk merangsang pertumbuhan rambut seperti minoxidil dan obat untuk mengobati seperti anthralin",
            79.33
        ))

        skins.add(skinsEntity(
            "Granuloma Annulare",
            R.drawable.granuloma,
            "Dapat disebabkan oleh infeksi seperti hepatitis, gigitan serangga, vaksinasi, paparan sinar matahari, obat obatan tertentu, dan cedera ringan pada kulit",
            "Umumnya akan muncul benjolan-benjolan dengan bintik kuning di puncaknya, seperti bisul dimana benjolan bisa mengeluarkan cairan bening, membentuk keropeng atau koreng, dan meninggalkan bekas luka",
            "Untuk meredakan penyakit ini dapat menggunakan krim anjuran dokter, pemberian ice pack pada daerah ruam untuk meredakan gejala, terapi sinar dan obat obatan sesuai anjuran dokter",
            79.33
        ))
// 5
        skins.add(skinsEntity(
            "Atopic Dermatitis",
            R.drawable.atopic,
            "Disebabkan oleh faktor genetic, lingkungan, imunologi, gangguan fungsi pelindung kulit, dan infeksi.",
            "Munculnya ruam yang mengeluarkan cairan, kulit kering dan bersisik, kulit di telapak tangan atau area bawah mata mengkerut, kulit di sekitar mata lebih gelap, dan kulit dapat pecah-pecah serta mengeluarkan darah.",
            "Rajin membersihkan perlengkapan tidur, menggunakan selimut jika tidak tahan dingin, dan bersihkan rumah secara berkala. jika sudah terkena, dapat mengurangi gejala dengan mandi air hangat dan menggunakan obat salep.",
            79.33
        ))

        skins.add(skinsEntity(
            "Bullous Pemphigoid",
            R.drawable.bullous,
            "Disebabkan oleh penyakit autoimun yang mana sistem kekebalan tubuh berbalik menyerang jaringan kulit kita.",
            "Pertama berubahnya warna kulit menjadi kemerahan, kehitaman, dan terasa gatal yang umumnya muncul di bagian lipatan kulit dan kemudian setelah beberapa minggu atau bulan, pada permukaan kulit tersebut muncul luka lepuh yang berisi cairan bening bercampur darah.",
            "Hindari mengonsumsi makanan keras atau renyah, hindari aktivitas yang dapat melukai kulit, dan kelola stress dengan baik. jika sudah terkena, dapat menggunakan obat rekomendasi dokter yang dapat membantu meredakan gejala.",
            79.33
        ))

        skins.add(skinsEntity(
            "Candidiasis",
            R.drawable.candidiasis,
            "Disebabkan oleh jamur Candida albicans",
            "Munculnya bercak putih atau kuning di lidah, bibir, gusi, langit-langit mulut, dan pipi bagian dalam. lalu kemerahan di mulut dan tenggorokan. kemudian kulit akan terasa pecah-pecah di sudut mulut dan rasa nyeri saat menelan",
            "Perawatan diri dapat dimulai dengan menjaga kebersihan mulut dan gigi dengan rutin menggosok gigi dan melakukan pemeriksaan ke dokter gigi minimal 6 bulan sekali, menghentikan kebiasaan merokok, menggunakan pakaian yang nyaman dan menyerap keringat, dan rajin mengganti pakaian, pakaian dalam, dan kaos kaku, secara teratur",
            79.33
        ))

        skins.add(skinsEntity(
            "Contact Dermatitis",
            R.drawable.contact,
            "Disebabkan ketika kulit terpapar dan terkena zat tertentu yang menyebabkan reaksi alergi atau iritasi",
            "Kulit akan terasa kering, melepuh, berwarna kemerahan, tampak gelap, kemudian kulit juga akan merasakan gatal yang hebat, perih, mulai sensitif terhadap cahaya matahari. dan dapat terjadi Pembengkakan pada mata, muka, atau selangkangan",
            "Dapat mengenakan pakaian pelindung untuk mengurangi kontak dengan zat penyebab penyakit ini serta sinar matahari. lalu menggunakan pelembab untuk memperbaiki kondisi kulit. dapat menggunakan krim atau obat obatan untuk mengurangi efek ketidaknyamanannya",
            79.33
        ))

        skins.add(skinsEntity(
            "Molluscum Contagiosum",
            R.drawable.molluscum,
            "Disebabkan oleh virus molluscum contagiosum",
            "Munculnya benjolan kecil seperti biji kacang, bisa muncul di wajah, leher, ketiak, perut, kelamin, dan tungkai. umumnya berwarna kulit, putih, atau merah muda. serta ada titik kecil berwarna putih kekuningan ditengah bintik",
            "Dapat mengolesi dibagian bintik menggunakan krim atau salep sesuai anjuran, scraping atau mengikis bintil menggunakan alat medis, dan membakar dengan terapi sinar laser",
            79.33
        ))
// 10
        skins.add(skinsEntity(
            "Seborrheic Dermatitis",
            R.drawable.seborrheicd,
            "Diduga disebabkan oleh jamur Malassezia furfur dan peradangan yang terkait dengan psoriasis",
            "Pada permukaan kulit akan berwarna kemerahan, terasa gatal, dan bersisik. timbulnya ketombe akibat kulit yang terkelupas yang dapat terjadi di kulit kepala atau daerah kumis, jenggot, dada, serta alis dan muncul ruam yang berbentuk bulat atau oval",
            "Untuk menghambat terjadinya kembali penyakit ini, dapat dilakukan keramas dengan sampo antijamur selama 5 menit, lalu bilas hingga bersih. Untuk membersihkan tubuh, gunakan sabun yang dapat menghilangkan minyak untuk mencegah timbulnya bakteri dan jamur. lalu angan gunakan produk perawatan kulit dan rambut yang mengandung alkohol, dan Hentikan penggunaan hair spray, gel, atau produk penataan rambut yang dapat memicu kambuhnya penyakit ini. kemudian untuk membantu mengobati dan meredakan penyakit ini dapat menggunakan obat dari anjuran dokter serta menggunakan shampo anti ketombe yang benar. serta perawatan diri seperti tidak menggaruk bagian tubuh yang terkena dermatitis seboroik dan menggunakan baju dengan bahan katun yang halus untuk mengurangi iritasi di permukaan kulit",
            79.33
        ))

        skins.add(skinsEntity(
            "Dermatitis Stasis",
            R.drawable.stasis,
            "Disebabkan oleh penyumbatan pada pembuluh darah vena yang mengakibatkan aliran darah dan menciptakan tekanan berlebih pada kulit.",
            "Munculnya ruam berwarna kemerahan, kulit terasa kering dan berkerak, kaki terasa sakit, dan kulit akan terasa sangat gatal.",
            "Penanganan yang dapat dilakukan sendiri yaitu jangan berdiri atau duduk terlalu lama, rajin olahraga untuk memperlancar aliran darah, dan dapat mengangkat kaki lebih tinggi dari posisi jantung untuk memperlancar serta mencegah penumpukan darah pada pembuluh darah.",
            79.33
        ))

        skins.add(skinsEntity(
            "Exanthem Viral",
            R.drawable.stasis,
            "Disebabkan oleh infeksi virus seperti campak, rubella, roseola, enterovirus, adnovirus, mononukleosis, dan jenis infeksi herpes. dapat juga dikarenakan karena respon imun, dan reaksi toksin oleh suatu organisme pada kulit",
            "Umumnya akan muncul bintik bintik kemerahan, bercak, dan dapat terasa gatal. bisa juga yang terinfeksi merasakan demam, sakit kepala, kehilangan selera makan, sakit perut, dan nyeri otot",
            "Hindari menyentuh mata, hidung, atau mulut dengan tangan kotor, bersihkan barang yang sering kita gunakan, jaga jarak dengan orang sakit, dan rajin mencuci tangan sampai bersih",
            79.33
        ))

        skins.add(skinsEntity(
            "Genital Warts",
            R.drawable.genital,
            "Disebabkan oleh virus human papillomavirus (HPV)",
            "Timbulnya tonjolan kulit dengan permukaan yang cenderung kasar. dapat juga terasa gatal, nyeri dan sensasi terbakar. dan penyakit yang muncul di liang vagina dapat menyebabkan keputihan dan pendarahan",
            "Untuk mencegah terkenanya penyakit ini dapat melakukan vaksin HPV serta berhati hati dalam berhubungan seksual. jika sudah terkena dapat diobati dengan menggunakan obat salep/krim seperti asam trikloroasetat, serta prosedur operasi seperti krioterapi",
            79.33
        ))

        skins.add(skinsEntity(
            "Herpes",
            R.drawable.herpes,
            "Disebabkan oleh virus herpes simpleks.",
            "Timbulnya pelepuhan pada kulit yang berwarna kemerahan dan berisi cairan. dan juga terasa nyeri dan gatal pada luka terinfeksi.",
            "Jika sudah terkena harus segera konsultasi terhadap dokter, umumnya akan diberi obat antivirus untuk mengurangi kemampuan dari virus itu untuk menyebar.",
            79.33
        ))
// 15
        skins.add(skinsEntity(
            "Impetigo",
            R.drawable.impetigo,
            "Disebabkan oleh bakteri staphylococcus pyogenes atau aureus",
            "Bercak kemerahan yang terasa gatal disekitar mulut atau hidung, kulit disekitar luka mengalami iritasi, dan terbentuknya koreng berwarna kuning kecokelatan di sekitar luka",
            "Rajin mencuci tangan, menutup luka bakteri, rajin memotong kuku, dan tidak menggaruk pada bagian infeksi",
            79.33
        ))

        skins.add(skinsEntity(
            "Keratoacanthoma",
            R.drawable.keratoacanthoma,
            "Disebabkan oleh pertumbuhan sel yang tidak normal karena cedera kulit dan sering terkena paparan sinar matahari",
            "Timbulnya benjolan berbentuk kubah dengan ukuran umum 1-3 inci dan memiliki sumbatan keras ditengah",
            "Jika sudah terkena dapat menggunakan obat antitumor, melakukan kemoterapi dan jika sudah buruk dilakukan operasi pengangkatan",
            79.33
        ))

        skins.add(skinsEntity(
            "Seborrheic Keratosis",
            R.drawable.seborrheick,
            "Disebabkan faktor genetic, sering terkena UV, dan faktor usia",
            "Terjadi pembengkakan yang terasa kasar, tebal, berbentuk oval umumnya, dan berwarna coklat, putih, atau kuning pada kulit",
            "Melakukan terapi krioterapi, dan terapi laser",
            79.33
        ))

        skins.add(skinsEntity(
            "Lichen Planus",
            R.drawable.lplanus,
            "Disebabkan oleh gangguan pada sistem kekebalan tubuh yang menyerang sel-sel kulit atau selaput lendir yang sehat",
            "Munculnya ruam kulit berwarna merah keunguan dan menonjol pada kulit, kulit akan tampak bersisik, akan terasa gatal pada permukaan kulit. munculnya bercak putih di mulut atau vagina yang dapat disertai rasa nyeri. mulut akan terasa kering dan pahit, lalu dapat terjadi kerusakan atau kehilangan pada kuku, dan mengalami kebotakan pada kepala",
            "Untuk perawatan diri dalam rumah yang dapat membantu mengurangi gejala meliputi : jangan menggaruk ruam yang terasa gatal untuk mencegah iritasi pada kulit, mengompres dengan air dingin, dan menggunakan lotion pelembab setelah mandi. untuk bagian infeksi pada mulut dapat dimulai dengan rajin menjaga kebersihan mulut dan gigi, serta jangan merokok, minum alkohol, dan mengonsumsi makanan minuman pedas atau asam. untuk pengobatan dari dokter bisa seperti krim, obat, atau fototerapi",
            79.33
        ))

        skins.add(skinsEntity(
            "Lichen Sclerosus",
            R.drawable.lsclerosus,
            "Dapat disebabkan oleh sistem kekebalan tubuh yang menyerang jaringan kulit yang sehat, serta juga dapat diduga dikarenakan ketidakseimbangan hormon",
            "Kulit akan terasa nyeri dengan warnanya yang kemerahan pada tempat yang terinfeksi, kemudian pada kemaluan akan merasakan rasa gatal yang hebat. lalu pada bercak infeksi dapat muncul robekan kulit yang berdarah dan pelepuhan pada luka terbuka yang berdarah jika sudah parah kondisinya",
            "Untuk pengobatannya dapat dimulai dengan mencuci secara perlahan area yang terinfeksi 1 - 2 kali sehari dengan sabun yang tidak mengandung pewangi atau deterjen, hindari menggaruk pada area penyakitnya walaupun terasa gatal, serta jangan menggunakan pakaian yang sempit serta lembab. dengan konsultasi dari dokter dapat menggunakan krim atau salep untuk meredakan gatal  memperbaiki kondisi kulit",
            79.33
        ))
        // 20
        skins.add(skinsEntity(
            "Lupus",
            R.drawable.lupus,
            "Disebabkan sistem kekebalan tubuh terganggu",
            "Badan mudah lelah, demam, nyeri pada sendi, dan muncul ruam pada kulit tubuh",
            "Batasi terpaparnya kulit dari matahari, hindari stress dan obat-obatan tertentu, berhenti merokok/jangan merokok, olahraga secara teratur, dan melakukan diet nutrisi",
            79.33
        ))

        skins.add(skinsEntity(
            "Melanoma",
            R.drawable.melanoma,
            "Disebabkan oleh virus",
            "Timbulnya tahi lalat yang membesar, perubahan warna pada tahu lalatnya, dan peradangan disekitar tahi lalat",
            "Segera kontak dokter terkait, pelaksanaan operasi, atau melakukan terapi kemoterapi atau radioterapi",
            79.33
        ))
        
        skins.add(skinsEntity(
            "Morphea",
            R.drawable.morphea,
            "Menurut ahli dapat disebabkan oleh gangguan sistem kekebalan tubuh",
            "Munculnya bercak oval kemerahan atau keunguan pada kulit, terutama di perut atau dada. terjadinya perubahan warna kulit lebih terang atau keputihan secara bertahap dengan pola warna tampak lurus, terutama pada lengan, dahi, atau tungkai serta bercak pada kulit yang terkena menjadi kencang, menebal, dan berkilau",
            "Untuk perawatan diri bisa memulai dengan menggunakan tabir surya setiap ingin keluar ruangan, hindari mandi dengan air panas terlalu lama, gunakan produk pelembab setelah mandi serta penggunaan produk lain berbahan dasar alami, selalu menjaga kelembapan udara, dan rajin berolahraga. jika sudah cukup parah, dapat berkonsultasi dengan dokter dimana dapat menggunakan obat dengan resep khusus serta dapat juga melakukan terapi cahaya",
            79.33
        ))

        skins.add(skinsEntity(
            "Onychomycosis",
            R.drawable.onychomycosis,
            "Disebebkan oleh 3 jenis organisme dermatophytes atau jamur yang menginfeksi rambut, kulit, dan kuku; yeast yaitu jamur lain yang tidak termasuk dermatophytes serta Candida albicans",
            "Kuku orang yang terkena akan mulai menebal, berubah warna serta bentuk dan jika semakin parah akan terasa nyeri ",
            "Untuk mengurangi terkenanya penyakit ini dapat lebih merawat kuku, sering mencuci tangan dan kaki hingga bersih, hindari berjalan kaki tanpa alas kaki, jangan berlama lama dalam alas kaki tertutup, serta penggunaan semprotan anti jamur pada alas kaki yang sering digunakan. jika sudah terkena dapat menggunakan obat anti jamur dari resep dokter atau jika sudah parah dapat dilakukan pembedahan",
            79.33
        ))

        skins.add(skinsEntity(
            "Phototoxic Reaction",
            R.drawable.phototoxic,
            "Disebabkan oleh reaksi bahan kimia di tubuh kita dan berinteraksi sinar UV matahari",
            "Orang yang terkena akan merasakan sensasi terbakar dan menyengat, umumnya juga akan muncul kemerahan pada permukaan kulit dalam waktu 24 jam setelah terkena sinar matahari",
            "Jika sudah mulai terjadi gejalanya, dapat menggunakan obat dari konsultasi dengan dokter. menggunakan pelindung sinar matahari untuk mengurangi efek lanjut dari penyakit ini. penggunaan kompres dingin juga dapat mengurangi efek ketidaknyamanannya",
            79.33
        ))
// 25
        skins.add(skinsEntity(
            "Pityriasis Rosea",
            R.drawable.pityriasis,
            "Diduga disebabkan oleh infeksi virus, terutama dari golongan virus herpes",
            "Penderita akan mengalami demam tinggi, kehilangan nafsu makan, mengalami gangguan pencernaan, nyeri sendi dan sakit kepala. dapat muncul Noda merah berbentuk oval menyerupai tambalan di area tersembunyi seperti ketiak dan area lainnya dan bercak merah yang menyebar hingga ke dada, punggung dan leher",
            "Untuk perawatan diri sendiri dapat dimulai dari sering menggunakan pelembab, mengompres kulit dengan air dingin, berendam dengan campuran oatmeal khusus, serta mengonsumsi obat sesuai anjuran dokter. untuk penanganan lainnya yaitu terapi sinar ultraviolet",
            79.33
        ))

        skins.add(skinsEntity(
            "Psoriasis",
            R.drawable.psoriasis,
            "Disebabkan oleh autoimun tubuh yang menyerang sel kulit sehat",
            "Timbul bercak merah dan diatas bercak tersebut terdapat sisik putih yang tebal serta berlapis-lapis",
            "Menggunakan obat oles atau krim, melakukan terapi cahaya, dan jika sudah parah, mengonsumsi obat dari arahan dokter",
            79.33
        ))

        skins.add(skinsEntity(
            "Rosacea",
            R.drawable.rosacea,
            "Disebabkan oleh bakteri helicobacter plylori",
            "Kulit pada bagian hidung, pipi, dagu, dan dahi menjadi kemerahan. dan juga dapat menimbulkan benjolan kecil, merah, dan bernanah.",
            "Dapat menggunakan tabir pelembab untuk kulit sensitif dan kering, dan obat yang dapat mengurangi kemerahan pada kulit",
            79.33
        ))

        skins.add(skinsEntity(
            "Scabies",
            R.drawable.scabies,
            "Disebabkan oleh Sarcoptes Scanbie Var Hominis.",
            "Kulit terasa sangat gatal pada malam hari. Gatal ini disertai dengan kemunculan ruam berbintik yang menyerupai jerawat atau lepuhan kecil bersisik.",
            "Penyakit ini mudah menular dari satu ke yang lain, jadi selalu menjaga kebersihan dan lingkungan sekitar juga.",
            79.33
        ))

        skins.add(skinsEntity(
            "Tuberous Sclerosis",
            R.drawable.tuberous,
            "Disebabkan oleh perubahan atau mutasi genetik yang mengendalikan pertumbuhan sel dalam tubuh dan terjadinya tumor",
            "Penderita akan mengalami penebalan di beberapa area kulit, muncul bercak berwarna terang, tumbuh jaringan di bawah atau di sekitar kuku, dan muncul benjolan kecil menyerupai jerawat di wajah",
            "Untuk penanganannya, pertama dapat meminum obat obatan untuk mengatasi gejala dan komplikasi yang akan timbul, kemudian dilaksanakan operasi pengangkatan tumor. lalu untuk pendukung lain dapat dilakukan terapi seperti fisioterapi agar penderita tetap dapat melaksanakan kegiatan sehari hari seperti biasa",
            79.33
        ))
// 30
        skins.add(skinsEntity(
            "Tinea",
            R.drawable.tinea,
            "Disebabkan oleh jamur.",
            "Kulit menjadi rusak dan terasa gatal.",
            "Dapat mengolesi dengan salep antijamur serta meminum obat antijamur.",
            79.33
        ))

        skins.add(skinsEntity(
            "Vascular Tumor",
            R.drawable.vascular,
            "Umumnya terjadi pada anak anak yaitu jenis hemangioma yang disebabkan oleh kelahiran yang prematur, berat badan yang rendah, faktor genetik, dan mengalami gangguan saat dalam kandungan",
            "Munculnya benjolan kenyal berwarna merah yang bisa tumbuh di mana saja, termasuk wajah, leher, kulit kepala, dada, punggung bayi, bahkan mata bayi. dan untuk remaja atau dewasa jika menderita penyakit ini juga akan muncul benjolan yang sama dan tempat tumbuh yang sebagian sama juga",
            "Jika sudah terkena, segera konsultasikan ke dokter. dimana umumnya akan diberi obat untuk menghambat dalam obat minum atau suntik, dan jika sudah parah dapat dilakukan terapi laser",
            79.33
        ))

        skins.add(skinsEntity(
            "Urticaria",
            R.drawable.urticaria,
            "Disebabkan karena terpicu oleh reaksi terhadap makanan atau obat obatan tertentu serta iritasi.",
            "Muncul berkas yang terasa gatal, menonjol, dan berwarna merah pada kulit.",
            "Biasanya dapat hilang dengan sendirinya, tetapi terdapat obat yang dapat membantu mengurangi gejalanya (antihistamin). serta dapat menggunakan kompres dingin untuk mengurangi iritasinya.",
            79.33
        ))

        skins.add(skinsEntity(
            "Vasculitis",
            R.drawable.vasculitis,
            "Dapat disebabkan oleh penyakit autoimun, seperti rheumatoid arthritis, lupus, atau skleroderma. dan juga reaksi alergi terhadap penggunaan obat-obatan tertentu",
            "Umumnya penderita akan merasakan pegal pegal, berkeringat di malam hari, kelelahan, munculnya ruam, demam, hilangnya denyut nadi pada tungkai tubuh, gangguan saraf seperti kebas atau lemas, dan turunnya berat badan",
            "Untuk mencegah penyakit ini terjadi dapat dilakukannya mempertahankan berat badan ideal, mengonsumsi makanan bergizi seimbang seperti sayur dan buah-buahan, rajin berolahraga, mengelola stress dengan baik, dan berhenti merokok. jika sudah terkena dapat meminum obat obatan sesuai anjuran dokter dan jika sudah parah harus dilaksanakan operasi untuk mencegah pecahnya pembuluh darah yang menyempit",
            79.33
        ))

        skins.add(skinsEntity(
            "Vitiligo",
            R.drawable.vitiligo,
            "Disebabkan oleh kondisi kulit yang tidak dapat memproduksi melamin yang menentukan warna kulit dan tidak dapat melindungi kulit dari efek buruk sinar matahari",
            "Hilangnya pigmen warna di rambut, janggut, bulu mata, dan alis (berwarna seperi keubanan). hilangnya juga pigmen warna pada bagian hitam mata, bagian dalam mulut dan hidung, serta di area kelamin. kemudian bagian tengah pada bercaknya berwarna putih dengan tepiannya yang berwarna kecoklatan atau kemerahan",
            "Untuk perawatan diri dan mengurangi terkenanya penyakit ini dapat menggunakan tabir surya, tetapi jika sudah memburuk direkomendasikan dilakukan terapi cahaya atau terapi laser, kemudian juga dapat dilakukan operasi pencakokan kulit",
            79.33
        ))

        return skins
    }

}