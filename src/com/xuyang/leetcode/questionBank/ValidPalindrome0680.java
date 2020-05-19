package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/19 16:09
 * 验证回文字符串 Ⅱ
 */
public class ValidPalindrome0680 {

    //给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

    /*
    考虑最朴素的方法：首先判断原串是否是回文串，如果是，就返回 true；如果不是，则枚举每一个位置作为被删除的位置，
    再判断剩下的字符串是否是回文串。这种做法的渐进时间复杂度是 O(n^2)O(n 2) 的，会超出时间限制。
     */
    //超出时间限制
    public boolean validPalindrome(String s) {
        if (helper(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {

            StringBuilder stringBuilder = new StringBuilder(s);
            stringBuilder.deleteCharAt(i);
            String s3 = stringBuilder.toString();
            if (helper(s3)) {
                return true;

            }

        }
        return false;


    }

    public boolean helper(String s) {

        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        String s2 = stringBuilder.toString();


        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s2.charAt(i)) {

                return false;

            }

        }
        return true;

    }

    //回文问题要想到 双指针

    public boolean validPalindrome2(String s) {
        int low =0,high=s.length()-1;

        while (low<high){
            char c1 = s.charAt(low),c2 = s.charAt(high);
            if (c1==c2){ //相同
                low++;
                high--;
            }else {//不相同，变索引，不删除，这样就很快
                boolean flag1 = true,flag2 = true;
                for (int i = low,j=high-1; i < j; i++,j--) {
                    char c3 = s.charAt(i),c4 = s.charAt(j);
                    if (c3!=c4){
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low+1,j=high; i < j; i++,j--) {
                    char c3 = s.charAt(i),c4 = s.charAt(j);
                    if (c3!=c4){
                        flag2 = false;
                        break;
                    }
                }
                return flag1||flag2;
            }


        }
        return true;

    }


    public static void main(String[] args) {
        ValidPalindrome0680 validPalindrome0680 = new ValidPalindrome0680();

        String s = "klsaantowecjcflbenbvqbpcwqwdjqkoabnggutmufdoanehqjpuilhhkpwyoqfrirjnjaxfkhhvzcrfvttmplcmmaozoxtwyuiqfxciflbngmjrfrsvbjexknigqpydmirqwkajorlxmcrbpjpjsnqydekxzczshliuilwacdwvpgpurusvjxhjaesjrigrurkjmahpvvmmgindehhenslzdcjipydoiiiqhrrtlzfeajxwedhsjdsxsdzxcuxedluwulntgmqxknzoiwbgdyiofabdlceflnegqfuiogcfyptzbewwxohfefgrljvmeaottxsegrpvpugjxtzgpnqvlcnfvytwdhoulxoetbmxxvmsbuqnmvciovrsjvynfbgtkvzqiiawwnvjimwjwutotlqnnosgyugefihlvgktlgyhfwngpkvkrqxmbhlhoekvquajdhietjzphinpnahbbzyjrtprevbxgvesphvvokzjrxkdjksdjgfocyiulkvqxlnqdutehneuwfufiotgizpqncacynizdqqnirzhduivyroykiismqiyblivbwnaxdwxtavvfvaltjwftqnknvwcyycjrqndxykupjvydkiuzqqgilecayrfqmnhidiucutobazhxchydomjpuzgvtksxvlfgrwsajuyowiguxngvrdbujleraonwrxkdtpesxloyftsvksnpnprvkcicaywaltdpbxqgkyrfuhhpltvuitjawfftcflbwiwvxpmnpcsgzwqjqtrgkwuhzrezaplaigbmzyuxitotiqudspmsybhexqthqytbowqgwtsilejruirppswvfqlkxwtnujdblterntyqkmxqnzgxmkhdpkfxfjcyggrygpnszroqntdacbjdoluzvliowxwkkmnvvferkbfjoswnxvbakwbtgzbptweivqbomqmnkbukchrpipjfcagmiarfqtdpbjnwbysbcrxifwvvvlsbdspvoonzbpotjfjtvtakwbruzrqcbhuqpyjnhheovhmoemooincegopruvootaugneicjckjwfnufpxtuvitozhdycfbphoqghhdxfkbdcowbkfsoppzagjiawtmimcvvakhhvyjattapvgjdfmbceauowgazjrosruiytfokbnflozrxxecwggikblpvclgohtvhirllrndaujhookqbiihjpwdvsecowxyvghhiartoowvmxiqpojdreroisculxrqrnsymoummzcsudjvmgxzoljhpztqaufhmvjqmjbrbrcjvldnlvqzizfykqgkhjfnccnaegemejfmapfqwrknldyhuyuggozgbwzjrytooihldrgjrhgmihofvkpowucwzesiybxmblmmorhlfqonncczxofhpdkfucsmtffvgzhghugendcmluiyxsafzfycjfdqkutduxehrdwofpcqfshsgefrayoirjdixihdwojmaeezrdbydypqdqjxggiextuqrlegytrqpndxculxzsqrptqhwshcgokwlgmsykrthobxfppvuufbkpqsetkfxcafceibattvudyuysglkujfutidjthpzfbyurbesxdgmfukmqzapkrrybokwgfccmgsdmixsnfbyddcarlibxxoborenumzrwlptdrmryzvkftuyvqxymzyuidvhdfccfcghtvbmwuegixdvafuilphfypolbjlggdvutchurgzoqmoejewptgzdfkyscbzlpbijefbwwtbfyrjumrtaxrehwywrjgpgmcvyhzoqboamqisxotnoqcgomqutrrrrefazlalrltqmxiupixuqanjuocsujljkjxrmaktaxdbzqbecxcztxdegmbhqvdqxastttafeddoejctkafelwkworkeegpruajiwxfzjglqzcvcweiecvpizegmmvrobkbcaaytiompokjjbmcaayvwyircxrezfyinruddtfguxkbdytwzrfsjwqjvireabcebipchndsiqcmcknfwwxfsxgigjxlpxudktwwpadioldcgvfxyzsazuqasmwgzeusptcgzkynfcqcipbtygofhaiayvykvxrxcdauwvxrasvsrgxiutlholdiimldstptxkuwsugglxltpymyewxqbjthptjmbyjfzvkvhfhwfvcjfqxnaaskjktqyqgakoxthtwllqbnoctorsdlqxdszsyndrexzedwpcluoxvdyiktnwwjfksesqapymlputivtajodwcmcfixxkviikyhgnxfxszalbbbdsuqlurcymilntnuebfzaclodkalnkncduyekflyptqzfqmgeedaawlsjclvzkrwzjxvjuqmhidddudxhkefgvczajktofbetjlckgwtbwdkrngwjtbabyxzxrrzvgnpqehnrviqsqjhambgurksjftfpwaoomdfumxbkcdzzkkydcyltryyrzdfbkbubjjetcwztnhvegfynwqhkryowoxyfvbhirngmgjkkvdvfmugjefipofsmpahcukhwqxlrvaxzgcfqoiecvbyjujfskokxysycbprkazlznprlwnawgbftredntauaeigxiepdmasyzmhdjpztplaujnpckkwvvvckqcqqyxtyorkzenvnudnmoerpzyxrrutnrkaakhyflbwchrtbeajelcsqubtitpyzbitqxlmcssflyikzakmftwpazqycngpukzcmsskmvfrzjrbugoiotbgiwcecnwqgrtdlculhxupvyagqlqrkxmeroelglszpnjxgvkstrgbafuctyhralwipuyrsrtnsxzatmpccjpzhifbqfvrpptvhhwllmbcatphbgcwlgdtwnkunoklnyexeupwhhcqpoucxajlcvgslacieevbpjxomwknuyhzjfrrolyvhyowwxrhhknngmyayafbjparzfcuranjnoarzgjipptifslyqwssbbjvqfnmqhyfvreerphilrdzrwwuiecniqrqpgvfvtirkkzbgkxqdjxnufaerhfvptscbvbqczifuzdgccmddrzeluythrfobstzsjmgqziixfhatwbqpsysrcmawzzjgxrrpawelcoxdpbmjnkwzhdqrfotbivmakpbyvccjzzxagquxczpwmordemlgigclfwrchrmqhajldfldkfzfbngoysltapsjbtvzbjdjzpdjwoautkjozjkzlestuplaeicpblgclntixfnyuwthrjglatacmxhyuwfuranfabmlahumvsjrmnkiijtgxxrnjutthoxucppvvolmktclvkcykoncmptuzfteimkhopxqshlnkxejifbtflrqvrvkjrnwpyjftkymhrozvttxvhecbchkqtllkmeysjnvltzswgsoewmsdxwkpdtrmbzkrynqpirzywjoplfcnzolxzeqqrsaesmcdsitipxfknvngxbyrwvgcbiyfsxpyoqjkkjmxwcsbrgxreizgbuspqzgalmzcbvincbqywnqzerxtlpuawijjgxrtkmlpehvxxzniwrjejjqfedjjtoqahmnohtuhfutzcamcasilftltznjzthglqeuctqsvifqonctznsjawmnllcbuezogwqqrzafpadevlispmiotdorftyccygfackncscxhratqkacvhhkfjiypbtjbyavfiljglnxxigrtzmymdltshczrjohnraujzisfpnvvuoqlnkdujwcfrgbkqlqnppbwikxwresqkyxsweragiyixpcpvvjtnhezsiykxxlmikizqjkaewzjweoewsavfdyikgxttgnhgsnkgkspxccpblxtjouiadwnbbseavcamrdsjwiezubjsxrezgogfhyjukfnpjztbnsvtfheggyhlcgxpaddaqsutkdljkwkaaafxtvzoivhocktqmofzrhafxqoblhhjrpbcnyzsdkvkcmsoxazafosesjlnjyoettdwnmqkxdcimcbldmmqzspxhifojxjleairjcteaddonsfwcyhbfcyqxyicpnhahorooqoldioqpjbfcuaqqrrocfuwfbjuemqyqvpzuunprtiwdamuhkyybkiiuoojifadslwdhpzbunsfqxizizmdvakibucdxotvnwjgccjasfrriaxrqzmvkojpoqifohhlzrkxvhfebvordbxcpxrpdfybmmatctdsrqrlqzftbwjvenuhxhaifwoemophxqlmkhhtzbndjaplsjuqcalzawyequpslwmyubmwgwndiweplgeqitrhxztkbymcvtosuyvoxlmifinztgnuumbaspfwdozuvgowmtcxupbndgqxikphfddgpzunlmgtjjbcifbesbixapmgzzibvaiblhygmegcjbidgzkmiyugkjiyhguvxlkubbvkcndlelbwvhlibqcshaouwzqhgrlxlrtkutvjidblhelmoefqxtkurynagvktphmfleumxshgpmebvncvwroqvnbftioebhkbhbeuojblcwgfnfjfihlyxirslpjxpeggsruoexjljkgoshcuwfpuicemrpsdfvvkgncybiuinxdsbiezinaelixxrlyttrgyeatbtrhlxxraspltulbgqiydvpffhcnsusdukwtdsesamgkefppswjfmhgfgqarzptcuifepeafqzpdtbumnicborftrtzavajljcofrcdewcrqaviunzlgwzxpetxbnfsecqtokfmwmamluxddgyksxejxpuytbpfdyjyltidnobxhwoojdaxmmlkiodgpddtojnszzuhevdhwnliyiemkpgkasnlmlgqqfsxpdixpsqfgwhwaepbbztkybcnmrokccdysncdktjkxdoiscpawlanilxcgukkusvydbxoyvfwuxicwnksxffndtewxigzzgixwetdnffxsknwcixuwfvyoxbdyvsaukkugcxlinalwapcsiodxkjtkdcnsydcckormncbyktzbbpeawhwgfqspxidpxsfqqglmlnsakgpkmeiyilnwhdvehuzzsnjotddpgdoiklmmxadjoowhxbonditlyjydfpbtyupxjexskygddxulmamwmfkotqcesfnbxtepxzwglznuivaqrcwedcrfocjljavaztrtfrobcinmubtdpzqfaepefiuctpzraqgfghmfjwsppfekgmasesdtwkudsusnchffpvdyiqgblutlpsarxxlhrtbtaeygrttylrxxileanizeibsdxniuibycngkvvfdsprmeciupfwuchsogkjljxeoursggepxjplsrixylhifjfnfgwclbjouebhbkhbeoitfbnvqorwvcnvbempghsxmuelmhptkvganyruktxqfeomlehlbdijvtuktrlxlrghqzwuoahscqbilhvwbleldnckvbbuklxvughyijkguyimkzgdibjcgemgyhlbiavbizzgmpaxibsebficbjjtgmlnuzpgddfhpkixqgdnbpuxctmwogvuzodwfpsabmuungtznifimlxovyusotvcmybktzxhrtiqeglpewidnwgwmbuymwlspuqeywazlacqujslpajdnbzthhkmlqxhpomeowfiahxhunevjwbtfzqlrqrsdtctammbyfdprxpcxbdrovbefhvxkrzlhhofiqopjokvmzqrxairrfsajccgjwnvtoxdcubikavdmzizixqfsnubzphdwlsdafijoouiikbyykhumadwitrpnuuzpvqyqmeujbfwufcorrqqaucfbjpqoidloqoorohahnpciyxqycfbhycwfsnoddaetcjriaeljxjofihxpszqmmdlbcmicdxkqmnwdtteoyjnljsesofazaxosmckvkdszyncbprjhhlboqxfahrzfomqtkcohviozvtxfaaakwkjldktusqaddapxgclhyggehftvsnbtzjpnfkujyhfgogzerxsjbuzeiwjsdrmacvaesbbnwdaiuojtxlbpccxpskgknsghngttxgkiydfvasweoewjzweakjqzikimlxxkyiszehntjvvpcpxiyigarewsxykqserwxkiwbppnqlqkbgrfcwjudknlqouvvnpfsizjuarnhojrzchstldmymztrgixxnlgjlifvaybjtbpyijfkhhvcakqtarhxcscnkcafgyccytfrodtoimpsilvedapfazrqqwgozeubcllnmwajsnztcnoqfivsqtcueqlghtzjnztltflisacmacztufhuthonmhaqotjjdefqjjejrwinzxxvheplmktrxgjjiwaupltxrezqnwyqbcnivbczmlagzqpsubgzierxgrbscwxmjkkjqoypxsfyibcgvwrybxgnvnkfxpitisdcmseasrqqezxlozncflpojwyzripqnyrkzbmrtdpkwxdsmweosgwsztlvnjsyemklltqkhcbcehvxttvzorhmyktfjypwnrjkvrvqrlftbfijexknlhsqxpohkmietfzutpmcnokyckvlctkmlovvppcuxohttujnrxxgtjiiknmrjsvmuhalmbafnarufwuyhxmcatalgjrhtwuynfxitnlcglbpciealputselzkjzojktuaowjdpzjdjbzvtbjspatlsyognbfzfkdlfdljahqmrhcrwflcgiglmedromwpzcxuqgaxzzjccvybpkamvibtofrqdhzwknjmbpdxoclewaprrxgjzzwamcrsyspqbwtahfxiizqgmjsztsbofrhtyulezrddmccgdzufizcqbvbcstpvfhreafunxjdqxkgbzkkritvfvgpqrqinceiuwwrzdrlihpreervfyhqmnfqvjbbsswqylsfitppijgzraonjnarucfzrapjbfayaymgnnkhhrxwwoyhvylorrfjzhyunkwmoxjpbveeicalsgvcljaxcuopqchhwpuexeynlkonuknwtdglwcgbhptacbmllwhhvtpprvfqbfihzpjccpmtazxsntrsryupiwlarhytcufabgrtskvgxjnpzslgleoremxkrqlqgayvpuxhlucldtrgqwncecwigbtoiogubrjzrfvmkssmczkupgncyqzapwtfmkazkiylfsscmlxqtibzyptitbuqsclejaebtrhcwblfyhkaakrnturrxyzpreomndunvnezkroytxyqqcqkcvvvwkkcpnjualptzpjdhmzysamdpeixgieauatndertfbgwanwlrpnzlzakrpbcysyxkoksfjujybvceioqfcgzxavrlxqwhkuchapmsfopifejgumfvdvkkjgmgnrihbvfyxowoyrkhqwnyfgevhntzwctejjbubkbfdzryyrtlycdykkzzdckbxmufdmooawpftfjskrugbmahjqsqivrnheqpngvzrrxzxybabtjwgnrkdwbtwgkcljtebfotkjazcvgfekhxdudddihmqujvxjzwrkzvlcjslwaadeegmqfzqtpylfkeyudcnknlakdolcazfbeuntnlimycrulqusdbbblazsxfxnghykiivkxxifcmcwdojatvituplmypaqseskfjwwntkiydvxoulcpwdezxerdnyszsdxqldsrotconbqllwthtxokagqyqtkjksaanxqfjcvfwhfhvkvzfjybmjtphtjbqxweymyptlxlgguswukxtptsdlmiidlohltuixgrsvsarxvwuadcxrxvkyvyaiahfogytbpicqcfnykzgctpsuezgwmsaquzaszyxfvgcdloidapwwtkduxplxjgigxsfxwwfnkcmcqisdnhcpibecbaerivjqwjsfrzwtydbkxugftddurniyfzerxcriywvyaacmbjjkopmoityaacbkborvmmgezipvceiewcvczqlgjzfxwijaurpgeekrowkwlefaktcjeoddefatttsaxqdvqhbmgedxtzcxcebqzbdxatkamrxjkjljuscoujnaquxipuixmqtlrlalzaferrrrtuqmogcqontoxsiqmaobqozhyvcmgpgjrwywherxatrmujryfbtwwbfejibplzbcsykfdzgtpwejeomqozgruhctuvdggljblopyfhpliufavdxigeuwmbvthgcfccfdhvdiuyzmyxqvyutfkvzyrmrdtplwrzmuneroboxxbilracddybfnsximdsgmccfgwkobyrrkpazqmkufmgdxsebruybfzphtjditufjuklgsyuyduvttabiecfacxfktesqpkbfuuvppfxbohtrkysmglwkogchswhqtprqszxlucxdnpqrtygelrqutxeiggxjqdqpydybdrzeeamjowdhixidjrioyarfegshsfqcpfowdrhexudtukqdfjcyfzfasxyiulmcdneguhghzgvfftmscufkdphfoxzccnnoqflhrommlbmxbyisezwcuwopkvfohimghrjgrdlhiootyrjzwbgzogguyuhydlnkrwqfpamfjemegeanccnfjhkgqkyfzizqvlndlvjcrbrbjmqjvmhfuaqtzphjlozxgmvjdusczmmuomysnrqrxlucsiorerdjopqixmvwootraihhgvyxwocesvdwpjhiibqkoohjuadnrllrihvthoglcvplbkiggwcexxrzolfnbkoftyiursorjzagwouaecbmfdjgvpattajyvhhkavvcmimtwaijgazpposfkbwocdbkfxdhhgqohpbfcydhzotivutxpfunfwjkcjcienguatoovurpogecnioomeomhvoehhnjypquhbcqrzurbwkatvtjfjtopbznoovpsdbslvvvwfixrcbsybwnjbpdtqfraimgacfjpiprhckubknmqmobqviewtpbzgtbwkabvxnwsojfbkrefvvnmkkwxwoilvzulodjbcadtnqorzsnpgyrggycjfxfkpdhkmxgznqxmkqytnretlbdjuntwxklqfvwsppriurjelistwgqwobtyqhtqxehbysmpsduqitotixuyzmbgialpazerzhuwkgrtqjqwzgscpnmpxvwiwblfctffwajtiuvtlphhufrykgqxbpdtlawyacickvrpnpnskvstfyolxseptdkxrwnoareljubdrvgnxugiwoyujaswrgflvxsktvgzupjmodyhcxhzabotucuidihnmqfryaceligqqzuikdyvjpukyxdnqrjcyycwvnknqtfwjtlavfvvatxwdxanwbvilbyiqmsiikyoryviudhzrinqqdzinycacnqpzigtoifufwuenhetudqnlxqvkluiycofgjdskjdkxrjzkovvhpsevgxbverptrjyzbbhanpnihpzjteihdjauqvkeohlhbmxqrkvkpgnwfhygltkgvlhifeguygsonnqltotuwjwmijvnwwaiiqzvktgbfnyvjsrvoicvmnqubsmvxxmbteoxluohdwtyvfnclvqnpgztxjgupvprgesxttoaemvjlrgfefhoxwwebztpyfcgoiufqgenlfecldbafoiydgbwioznkxqmgtnluwuldexucxzdsxsdjshdewxjaefzltrrhqiiiodypijcdzlsnehhednigmmvvphamjkrurgirjseajhxjvsurupgpvwdcawliuilhszczxkedyqnsjpjpbrcmxlrojakwqrimdypqginkxejbvsrfrjmgnblficxfqiuywtxozoammclpmttvfrczvhhkfxajnjrirfqoywpkhhliupjqhenaodfumtuggnbaokqjdwqwcpbqvbneblfcjcewotnaaslk";
        boolean res= validPalindrome0680.validPalindrome2(s);
        System.out.println(res);
    }
}
