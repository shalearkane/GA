package org.maps.InputData;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Inputs {
    public static final int[][] processing_cost = {
            {0, 0, 0, 0},
            {0, 17720, 21264, 14176}, // 1
            {0, 18410, 22092, 14728}, // 2
            {0, 18290, 21948, 14632}, // 3
            {0, 18360, 22032, 14688}, // 4
            {0, 18730, 22476, 14984}, // 5
            {0, 17990, 21588, 14392}, // 6
            {0, 18060, 21672, 14448}, // 7
            {0, 18960, 22752, 15168}, // 8
            {0, 18180, 21816, 14544}, // 9
            {0, 18240, 21888, 14592}, // 10
            {0, 18840, 22608, 15072}, // 11
            {0, 17340, 20808, 13872}, // 12
            {0, 17910, 21492, 14328}, // 13
            {0, 18000, 21600, 14400}, // 14
            {0, 19090, 22908, 15272}, // 15
            {0, 18680, 22416, 14944}, // 16
            {0, 18730, 22476, 14984}, // 17
            {0, 18100, 21720, 14480}, // 18
            {0, 17850, 21420, 14280}, // 19
            {0, 18350, 22020, 14680}, // 20
            {0, 18350, 22020, 14680}, // 21
            {0, 19170, 23004, 15336}, // 22
            {0, 18460, 22152, 14768}, // 23
            {0, 472070, 566484, 377656}, // 24
            {0, 322500, 387000, 258000}, // 25
            {0, 564170, 677004, 451336}, // 26
            {0, 443950, 532740, 355160}, // 27
            {0, 344220, 413064, 275376}, // 28
            {0, 237670, 285204, 190136}, // 29
            {0, 234710, 281652, 187768}, // 30
            {0, 482750, 579300, 386200}, // 31
            {0, 246940, 296328, 197552}, // 32
            {0, 425010, 510012, 340008}, // 33
            {0, 297130, 356556, 237704}, // 34
            {0, 343570, 412284, 274856}, // 35
            {0, 338020, 405624, 270416}, // 36
            {0, 546640, 655968, 437312}, // 37
            {0, 525940, 631128, 420752}, // 38
            {0, 356630, 427956, 285304}, // 39
            {0, 670450, 804540, 536360}, // 40
            {0, 342180, 410616, 273744}, // 41
            {0, 450210, 540252, 360168}, // 42
            {0, 552330, 662796, 441864}, // 43
            {0, 545410, 654492, 436328}, // 44
            {0, 418110, 501732, 334488}, // 45
            {0, 516870, 620244, 413496}, // 46
            {0, 5460, 6552, 4368}, // 47
            {0, 5680, 6816, 4544}, // 48
            {0, 4610, 5532, 3688}, // 49
            {0, 4920, 5904, 3936}, // 50
            {0, 5820, 6984, 4656}, // 51
            {0, 5380, 6456, 4304}, // 52
            {0, 5210, 6252, 4168}, // 53
            {0, 4520, 5424, 3616}, // 54
            {0, 4660, 5592, 3728}, // 55
            {0, 5060, 6072, 4048}, // 56
            {0, 5440, 6528, 4352}, // 57
            {0, 5250, 6300, 4200}, // 58
            {0, 4250, 5100, 3400}, // 59
            {0, 5270, 6324, 4216}, // 60
            {0, 4910, 5892, 3928}, // 61
            {0, 4270, 5124, 3416}, // 62
            {0, 4350, 5220, 3480}, // 63
            {0, 5340, 6408, 4272}, // 64
            {0, 4710, 5652, 3768}, // 65
            {0, 5160, 6192, 4128}, // 66
            {0, 4670, 5604, 3736}, // 67
            {0, 5140, 6168, 4112}, // 68
            {0, 5650, 6780, 4520}, // 69
            {0, 5480, 6576, 4384}, // 70
            {0, 5200, 6240, 4160}, // 71
            {0, 5140, 6168, 4112}, // 72
            {0, 5320, 6384, 4256}, // 73
            {0, 451460, 541752, 361168}, // 74
            {0, 587360, 704832, 469888}, // 75
            {0, 616790, 740148, 493432}, // 76
            {0, 476750, 572100, 381400}, // 77
            {0, 424610, 509532, 339688}, // 78
            {0, 500550, 600660, 400440}, // 79
            {0, 297360, 356832, 237888}, // 80
            {0, 280430, 336516, 224344}, // 81
            {0, 531850, 638220, 425480}, // 82
            {0, 369430, 443316, 295544}, // 83
            {0, 421580, 505896, 337264}, // 84
            {0, 501110, 601332, 400888}, // 85
            {0, 628170, 753804, 502536}, // 86
            {0, 614490, 737388, 491592}, // 87
            {0, 451080, 541296, 360864}, // 88
            {0, 325350, 390420, 260280}, // 89
            {0, 436360, 523632, 349088}, // 90
            {0, 509460, 611352, 407568}, // 91
            {0, 307280, 368736, 245824}, // 92
            {0, 341890, 410268, 273512}, // 93
            {0, 502100, 602520, 401680}, // 94
            {0, 441360, 529632, 353088}, // 95
            {0, 256490, 307788, 205192}, // 96
            {0, 498930, 598716, 399144}, // 97
            {0, 5210, 6252, 4168}, // 98
            {0, 5460, 6552, 4368}, // 99
            {0, 4890, 5868, 3912}, // 100
    };
    public static final Comm_cost_pair[][] dag = new Comm_cost_pair[][]{
            {new Comm_cost_pair(0, 0)}, // 0
            {new Comm_cost_pair(24, 1),}, //1
            {new Comm_cost_pair(25, 1),}, //2
            {new Comm_cost_pair(26, 1),}, //3
            {new Comm_cost_pair(27, 1),}, //4
            {new Comm_cost_pair(28, 1),}, //5
            {new Comm_cost_pair(29, 1),}, //6
            {new Comm_cost_pair(30, 1),}, //7
            {new Comm_cost_pair(31, 1),}, //8
            {new Comm_cost_pair(32, 1),}, //9
            {new Comm_cost_pair(33, 1),}, //10
            {new Comm_cost_pair(34, 1),}, //11
            {new Comm_cost_pair(35, 1),}, //12
            {new Comm_cost_pair(36, 1),}, //13
            {new Comm_cost_pair(37, 1),}, //14
            {new Comm_cost_pair(38, 1),}, //15
            {new Comm_cost_pair(39, 1),}, //16
            {new Comm_cost_pair(40, 1),}, //17
            {new Comm_cost_pair(41, 1),}, //18
            {new Comm_cost_pair(42, 1),}, //19
            {new Comm_cost_pair(43, 1),}, //20
            {new Comm_cost_pair(44, 1),}, //21
            {new Comm_cost_pair(45, 1),}, //22
            {new Comm_cost_pair(46, 1),}, //23
            {new Comm_cost_pair(47, 1),}, //24
            {new Comm_cost_pair(47, 1),}, //25
            {new Comm_cost_pair(47, 1),}, //26
            {new Comm_cost_pair(47, 1),}, //27
            {new Comm_cost_pair(47, 1),}, //28
            {new Comm_cost_pair(47, 1),}, //29
            {new Comm_cost_pair(47, 1),}, //30
            {new Comm_cost_pair(47, 1),}, //31
            {new Comm_cost_pair(47, 1),}, //32
            {new Comm_cost_pair(47, 1),}, //33
            {new Comm_cost_pair(47, 1),}, //34
            {new Comm_cost_pair(48, 1),}, //35
            {new Comm_cost_pair(48, 1),}, //36
            {new Comm_cost_pair(48, 1),}, //37
            {new Comm_cost_pair(48, 1),}, //38
            {new Comm_cost_pair(48, 1),}, //39
            {new Comm_cost_pair(48, 1),}, //40
            {new Comm_cost_pair(48, 1),}, //41
            {new Comm_cost_pair(48, 1),}, //42
            {new Comm_cost_pair(49, 1), new Comm_cost_pair(48, 1),}, //43
            {new Comm_cost_pair(49, 1),}, //44
            {new Comm_cost_pair(49, 1),}, //45
            {new Comm_cost_pair(49, 1),}, //46
            {new Comm_cost_pair(52, 1), new Comm_cost_pair(60, 1), new Comm_cost_pair(56, 1), new Comm_cost_pair(50, 1), new Comm_cost_pair(55, 1), new Comm_cost_pair(54, 1), new Comm_cost_pair(57, 1), new Comm_cost_pair(58, 1), new Comm_cost_pair(51, 1), new Comm_cost_pair(53, 1), new Comm_cost_pair(59, 1),}, //47
            {new Comm_cost_pair(65, 1), new Comm_cost_pair(68, 1), new Comm_cost_pair(62, 1), new Comm_cost_pair(61, 1), new Comm_cost_pair(66, 1), new Comm_cost_pair(69, 1), new Comm_cost_pair(63, 1), new Comm_cost_pair(64, 1), new Comm_cost_pair(67, 1),}, //48
            {new Comm_cost_pair(73, 1), new Comm_cost_pair(71, 1), new Comm_cost_pair(72, 1), new Comm_cost_pair(70, 1),}, //49
            {new Comm_cost_pair(74, 1),}, //50
            {new Comm_cost_pair(75, 1),}, //51
            {new Comm_cost_pair(76, 1),}, //52
            {new Comm_cost_pair(77, 1),}, //53
            {new Comm_cost_pair(78, 1),}, //54
            {new Comm_cost_pair(79, 1),}, //55
            {new Comm_cost_pair(80, 1),}, //56
            {new Comm_cost_pair(81, 1),}, //57
            {new Comm_cost_pair(82, 1),}, //58
            {new Comm_cost_pair(83, 1),}, //59
            {new Comm_cost_pair(84, 1),}, //60
            {new Comm_cost_pair(85, 1),}, //61
            {new Comm_cost_pair(86, 1),}, //62
            {new Comm_cost_pair(87, 1),}, //63
            {new Comm_cost_pair(88, 1),}, //64
            {new Comm_cost_pair(89, 1),}, //65
            {new Comm_cost_pair(90, 1),}, //66
            {new Comm_cost_pair(91, 1),}, //67
            {new Comm_cost_pair(92, 1),}, //68
            {new Comm_cost_pair(93, 1),}, //69
            {new Comm_cost_pair(94, 1),}, //70
            {new Comm_cost_pair(95, 1),}, //71
            {new Comm_cost_pair(96, 1),}, //72
            {new Comm_cost_pair(97, 1),}, //73
            {new Comm_cost_pair(98, 1),}, //74
            {new Comm_cost_pair(98, 1),}, //75
            {new Comm_cost_pair(98, 1),}, //76
            {new Comm_cost_pair(98, 1),}, //77
            {new Comm_cost_pair(98, 1),}, //78
            {new Comm_cost_pair(98, 1),}, //79
            {new Comm_cost_pair(98, 1),}, //80
            {new Comm_cost_pair(98, 1),}, //81
            {new Comm_cost_pair(98, 1),}, //82
            {new Comm_cost_pair(98, 1),}, //83
            {new Comm_cost_pair(98, 1),}, //84
            {new Comm_cost_pair(99, 1),}, //85
            {new Comm_cost_pair(99, 1),}, //86
            {new Comm_cost_pair(99, 1),}, //87
            {new Comm_cost_pair(99, 1),}, //88
            {new Comm_cost_pair(99, 1),}, //89
            {new Comm_cost_pair(99, 1),}, //90
            {new Comm_cost_pair(99, 1),}, //91
            {new Comm_cost_pair(99, 1),}, //92
            {new Comm_cost_pair(99, 1),}, //93
            {new Comm_cost_pair(100, 1),}, //94
            {new Comm_cost_pair(100, 1),}, //95
            {new Comm_cost_pair(100, 1),}, //96
            {new Comm_cost_pair(100, 1),}, //97
            {}, //98
            {}, //99
            {}, //100
    };
    public static Vector<Set<Integer>> dependency = new Vector<>(Constants.MAX_TASKS + 1);

    public static void main(String[] args) {
        System.out.println("Processing costs");
        for (int[] pc_cost : processing_cost) {
            System.out.println();
            for (int cost_on_processor : pc_cost) {
                System.out.print(cost_on_processor + ", ");
            }
        }

        System.out.println("Comm cost pair");
        for (Comm_cost_pair[] pairs : dag) {
            System.out.println();
            for (Comm_cost_pair p : pairs) {
                System.out.print(p.to_node + " : " + p.to_node + ", ");
            }
        }
    }

    public static void generate_dependency_table() {
        //
        for (int i = 0; i <= Constants.MAX_TASKS; i++) {
            dependency.add(i, new HashSet<>());
        }
        for (int i = 1; i <= Constants.MAX_TASKS; i++) {
            Comm_cost_pair[] ccp = dag[i];
            for (Comm_cost_pair p : ccp) {
                Set<Integer> s = dependency.get(p.to_node);
                s.add(i);
                dependency.set(p.to_node, s);
            }
        }
    }
}
