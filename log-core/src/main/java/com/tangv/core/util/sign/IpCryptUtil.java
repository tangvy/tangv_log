package com.tangv.core.util.sign;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class IpCryptUtil {

    /**
     * 随机生成
     * String arr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
     * Set<String> builder = new HashSet<>();
     * <p>
     * <p>
     * for (int i = 0; i < arr.length(); i++) {
     * <p>
     * for (int k = 0; k < arr.length(); k++) {
     * builder.add("\"" + arr.charAt(i) + "" + arr.charAt(k) + "\"");
     * builder.add("\"" + arr.charAt(k) + "" + arr.charAt(i) + "\"");
     * }
     * <p>
     * }
     */
    private final static String[] hex = {"Ue", "VF", "3b", "4C", "p9", "nw", "oX", "N6", "Lt", "MU", "fg", "gH", "Dc", "ff", "gG", "ED", "wh", "xI", "3c", "4D", "N7", "nx", "oY", "Lu", "MV", "De", "fh", "gI", "EF", "Dd", "EE", "Uf", "wi", "xJ", "VG", "ny", "oZ", "N8", "Lv", "MW", "fi", "gJ", "Df", "EG", "wj", "xK", "Ug", "VH", "3d", "4E", "N9", "nz", "Lw", "MX", "fj", "Dg", "gK", "EH", "Uh", "wk", "xL", "VI", "3e", "4F", "Lx", "MY", "fk", "gL", "Dh", "EI", "wl", "xM", "Ui", "VJ", "3f", "4G", "Ly", "MZ", "fl", "gM", "Di", "EJ", "Uj", "wm", "xN", "VK", "3g", "4H", "Lz", "fm", "gN", "Dj", "EK", "y0", "wn", "xO", "Uk", "VL", "3h", "4I", "h0", "fn", "gO", "Dk", "EL", "y1", "Ul", "wo", "xP", "VM", "3i", "4J", "h1", "fo", "gP", "Dl", "EM", "y2", "wp", "xQ", "Um", "VN", "3j", "4K", "pA", "h2", "fp", "gQ", "Dm", "EN", "W0", "y3", "Un", "wq", "xR", "VO", "3k", "4L", "oa", "pB", "h3", "fq", "gR", "F0", "Dn", "EO", "y4", "wr", "xS", "W1", "Uo", "VP", "3l", "4M", "ob", "pC", "F1", "h4", "fr", "gS", "Do", "EP", "W2", "y5", "Up", "ws", "xT", "VQ", "3m", "4N", "oc", "pD", "NA", "h5", "fs", "gT", "F2", "Dp", "EQ", "y6", "wt", "xU", "W3", "Uq", "VR", "50", "3n", "4O", "od", "pE", "Ma", "NB", "F3", "h6", "ft", "gU", "Dq", "ER", "W4", "y7", "Ur", "wu", "xV", "VS", "51", "3o", "4P", "Mb", "oe", "pF", "NC", "h7", "fu", "gV", "F4", "Dr", "ES", "y8", "wv", "xW", "W5", "Us", "VT", "52", "3p", "4Q", "of", "pG", "Mc", "ND", "F5", "h8", "fv", "gW", "Ds", "ET", "wx", "xY", "W6", "y9", "Ut", "ww", "xX", "VU", "53", "3q", "4R", "Md", "og", "pH", "NE", "F6", "Dt", "EU", "W8", "Uv", "wy", "xZ", "VW", "W7", "Uu", "VV", "3r", "54", "4S", "oh", "pI", "Me", "NF", "h9", "fw", "gX", "wz", "W9", "Uw", "VX", "3t", "4U", "56", "3s", "4T", "55", "Mf", "oi", "pJ", "NG", "F7", "fx", "gY", "Du", "EV", "Ux", "VY", "3u", "4V", "57", "oj", "pK", "Mg", "NH", "fy", "gZ", "F8", "Dv", "EW", "Uy", "VZ", "3v", "4W", "58", "Mh", "ok", "pL", "NI", "F9", "fz", "Dw", "EX", "Uz", "3w", "4X", "59", "ol", "pM", "Mi", "NJ", "Dx", "EY", "3x", "4Y", "Mj", "om", "pN", "NK", "Dy", "EZ", "yA", "3y", "4Z", "q0", "on", "pO", "Mk", "NL", "Dz", "xa", "yB", "3z", "q2", "op", "pQ", "q1", "Ml", "oo", "pP", "NM", "xb", "yC", "O0", "q3", "Mn", "oq", "pR", "NO", "Mm", "NN", "hA", "xc", "yD", "WA", "q4", "or", "pS", "O1", "Mo", "NP", "ga", "hB", "Va", "xd", "yE", "WB", "O2", "q5", "os", "Mp", "pT", "NQ", "gb", "hC", "xe", "yF", "Vb", "WC", "q6", "ot", "pU", "O3", "Mq", "NR", "gc", "hD", "FA", "Vc", "xf", "yG", "WD", "5A", "O4", "q7", "ou", "pV", "Mr", "NS", "gd", "hE", "Ea", "FB", "xg", "yH", "Vd", "WE", "4a", "5B", "q8", "ov", "pW", "O5", "Ms", "NT", "Eb", "ge", "hF", "FC", "Ve", "xh", "yI", "WF", "4b", "5C", "O6", "q9", "ow", "pX", "Mt", "NU", "gf", "hG", "Ec", "FD", "Vf", "WG", "4c", "5D", "ox", "pY", "O7", "Mu", "NV", "gh", "hI", "Ed", "gg", "hH", "FE", "xi", "yJ", "4d", "5E", "O8", "oy", "pZ", "Mv", "NW", "Ef", "gi", "hJ", "FG", "Ee", "FF", "Vg", "xj", "yK", "WH", "oz", "O9", "Mw", "NX", "gj", "hK", "Eg", "FH", "xk", "yL", "Vh", "WI", "4e", "5F", "Mx", "NY", "gk", "Eh", "hL", "FI", "Vi", "xl", "yM", "WJ", "4f", "5G", "My", "NZ", "gl", "hM", "Ei", "FJ", "xm", "yN", "Vj", "WK", "4g", "5H", "Mz", "gm", "hN", "Ej", "FK", "z0", "Vk", "xn", "yO", "WL", "4h", "5I", "i0", "gn", "hO", "Ek", "FL", "z1", "xo", "yP", "Vl", "WM", "4i", "5J", "qA", "i1", "go", "hP", "El", "FM", "z2", "Vm", "xp", "yQ", "WN", "4j", "5K", "i2", "gp", "hQ", "Em", "FN", "z3", "xq", "yR", "X0", "Vn", "WO", "4k", "5L", "pa", "qB", "G0", "i3", "gq", "hR", "En", "FO", "X1", "z4", "Vo", "xr", "yS", "WP", "4l", "5M", "pb", "qC", "i4", "gr", "hS", "G1", "Eo", "FP", "z5", "xs", "yT", "X2", "Vp", "WQ", "4m", "5N", "pc", "qD", "OA", "G2", "i5", "gs", "hT", "Ep", "FQ", "X3", "z6", "Vq", "xt", "yU", "WR", "60", "4n", "5O", "Na", "pd", "qE", "OB", "i6", "gt", "hU", "G3", "Eq", "FR", "z7", "xu", "yV", "X4", "Vr", "WS", "61", "4o", "5P", "pe", "qF", "Nb", "OC", "G4", "i7", "gu", "hV", "Er", "FS", "X5", "z8", "Vs", "xv", "yW", "WT", "62", "4p", "5Q", "Nc", "pf", "qG", "OD", "i8", "gv", "hW", "G5", "Es", "FT", "z9", "xw", "yX", "X6", "Vt", "WU", "63", "4q", "5R", "pg", "qH", "Nd", "OE", "G6", "i9", "gw", "hX", "Et", "FU", "xy", "yZ", "X7", "Vu", "xx", "yY", "WV", "64", "4r", "5S", "Ne", "ph", "qI", "OF", "G7", "Eu", "FV", "X9", "Vw", "xz", "WX", "X8", "Vv", "WW", "4s", "65", "5T", "pi", "qJ", "Nf", "OG", "gx", "hY", "Vx", "WY", "4u", "5V", "67", "4t", "5U", "66", "Ng", "pj", "qK", "OH", "G8", "gy", "hZ", "Ev", "FW", "Vy", "WZ", "4v", "5W", "68", "pk", "qL", "Nh", "OI", "gz", "G9", "Ew", "FX", "Vz", "4w", "5X", "69", "Ni", "pl", "qM", "OJ", "Ex", "FY", "4x", "5Y", "pm", "qN", "Nj", "OK", "Ey", "FZ", "zA", "4y", "5Z", "r0", "Nk", "pn", "qO", "OL", "Ez", "a0", "ya", "zB", "4z", "r1", "po", "qP", "Nl", "OM", "a1", "yb", "zC", "r3", "pq", "qR", "r2", "Nm", "pp", "qQ", "ON", "iA", "yc", "zD", "XA", "P1", "r4", "No", "pr", "qS", "OP", "P0", "Nn", "OO", "ha", "iB", "a2", "yd", "zE", "Wa", "XB", "r5", "ps", "qT", "P2", "Np", "OQ", "hb", "iC", "a3", "Wb", "ye", "zF", "XC", "P3", "r6", "pt", "Nq", "qU", "OR", "hc", "iD", "GA", "a4", "yf", "zG", "Wc", "XD", "6A", "r7", "pu", "qV", "P4", "Nr", "OS", "Fa", "hd", "iE", "GB", "a5", "Wd", "yg", "zH", "XE", "5a", "6B", "P5", "r8", "pv", "qW", "Ns", "OT", "he", "iF", "Fb", "GC", "a6", "yh", "zI", "We", "XF", "5b", "6C", "r9", "pw", "qX", "P6", "Nt", "OU", "Fc", "hf", "iG", "GD", "a7", "Wf", "yi", "zJ", "XG", "5c", "6D", "P7", "px", "qY", "Nu", "OV", "hg", "iH", "Fd", "GE", "a8", "Wg", "XH", "5d", "6E", "py", "qZ", "P8", "Nv", "OW", "hi", "iJ", "Fe", "hh", "iI", "GF", "a9", "yj", "zK", "5e", "6F", "P9", "pz", "Nw", "OX", "Fg", "hj", "iK", "GH", "Ff", "GG", "Wh", "yk", "zL", "XI", "Nx", "OY", "hk", "iL", "Fh", "GI", "yl", "zM", "Wi", "XJ", "5f", "6G", "Ny", "OZ", "hl", "Fi", "iM", "GJ", "Wj", "ym", "zN", "XK", "5g", "6H", "Nz", "hm", "iN", "Fj", "GK", "yn", "zO", "Wk", "XL", "5h", "6I", "j0", "hn", "iO", "Fk", "GL", "Wl", "yo", "zP", "XM", "5i", "6J", "rA", "j1", "ho", "iP", "Fl", "GM", "yp", "zQ", "Wm", "XN", "5j", "6K", "qa", "rB", "j2", "hp", "iQ", "Fm", "GN", "Y0", "Wn", "yq", "zR", "XO", "5k", "6L", "j3", "hq", "iR", "H0", "Fn", "GO", "aB", "aA", "yr", "zS", "Y1", "Wo", "XP", "5l", "6M", "qb", "rC", "H1", "j4", "hr", "iS", "Fo", "GP", "aC", "Y2", "Wp", "ys", "zT", "XQ", "5m", "6N", "qc", "rD", "PA", "j5", "hs", "iT", "H2", "Fp", "GQ", "aD", "yt", "zU", "Y3", "Wq", "XR", "70", "5n", "6O", "qd", "rE", "Oa", "PB", "H3", "j6", "ht", "iU", "Fq", "GR", "aE", "Y4", "Wr", "yu", "zV", "XS", "71", "5o", "6P", "Ob", "qe", "rF", "PC", "j7", "hu", "iV", "H4", "Fr", "GS", "aF", "yv", "zW", "Y5", "Ws", "XT", "72", "5p", "6Q", "qf", "rG", "Oc", "PD", "H5", "j8", "hv", "iW", "Fs", "GT", "aG", "Y6", "Wt", "yw", "zX", "XU", "73", "5q", "6R", "Od", "qg", "rH", "PE", "j9", "hw", "iX", "H6", "Ft", "GU", "aH", "yx", "zY", "Y7", "Wu", "XV", "74", "5r", "6S", "qh", "rI", "Oe", "PF", "H7", "hx", "iY", "Fu", "GV", "aI", "yz", "Y8", "Wv", "yy", "zZ", "XW", "75", "5s", "6T", "Of", "qi", "rJ", "PG", "H8", "Fv", "GW", "aJ", "Wx", "XY", "Y9", "Ww", "XX", "5t", "76", "6U", "qj", "rK", "Og", "PH", "hy", "iZ", "aK", "Wy", "XZ", "5v", "6W", "78", "5u", "6V", "77", "Oh", "qk", "rL", "PI", "H9", "hz", "Fw", "GX", "aL", "Wz", "5w", "6X", "79", "ql", "rM", "Oi", "PJ", "Fx", "GY", "aM", "5x", "6Y", "Oj", "qm", "rN", "PK", "Fy", "GZ", "aN", "5y", "6Z", "s0", "qn", "rO", "Ok", "PL", "Fz", "b0", "aO", "za", "5z", "s1", "Ol", "qo", "rP", "PM", "b1", "aP", "zb", "s2", "qp", "rQ", "Om", "PN", "jA", "b2", "aQ", "zc", "YA", "s4", "qr", "rS", "Q0", "s3", "On", "qq", "rR", "PO", "ia", "jB", "Xa", "zd", "YB", "Q2", "s5", "Op", "qs", "rT", "PQ", "Q1", "Oo", "PP", "ib", "jC", "b3", "aR", "ze", "Xb", "YC", "s6", "qt", "rU", "Q3", "Oq", "PR", "ic", "jD", "HA", "b4", "aS", "Xc", "zf", "YD", "7A", "Q4", "s7", "qu", "Or", "rV", "PS", "id", "jE", "Ga", "HB", "b5", "aT", "zg", "Xd", "YE", "6a", "7B", "s8", "qv", "rW", "Q5", "Os", "PT", "Gb", "ie", "jF", "HC", "b6", "aU", "Xe", "zh", "YF", "6b", "7C", "Q6", "s9", "qw", "rX", "Ot", "PU", "if", "jG", "Gc", "HD", "b7", "aV", "zi", "Xf", "YG", "6c", "7D", "qx", "rY", "Q7", "Ou", "PV", "Gd", "ig", "jH", "HE", "b8", "aW", "Xg", "zj", "YH", "6d", "7E", "Q8", "qy", "rZ", "Ov", "PW", "ih", "jI", "Ge", "HF", "b9", "aX", "Xh", "YI", "6e", "7F", "qz", "Q9", "Ow", "PX", "ij", "jK", "Gf", "ii", "jJ", "HG", "aY", "zk", "6f", "7G", "Ox", "PY", "Gh", "ik", "jL", "HI", "Gg", "HH", "aZ", "Xi", "zl", "YJ", "Oy", "PZ", "il", "jM", "Gi", "HJ", "zm", "Xj", "YK", "6g", "7H", "Oz", "im", "Gj", "jN", "HK", "Xk", "zn", "YL", "6h", "7I", "k0", "in", "jO", "Gk", "HL", "zo", "Xl", "YM", "6i", "7J", "sA", "k1", "io", "jP", "Gl", "HM", "Xm", "zp", "YN", "6j", "7K", "ra", "sB", "k2", "ip", "jQ", "Gm", "HN", "zq", "Z0", "Xn", "YO", "6k", "7L", "rb", "sC", "I0", "k3", "iq", "jR", "Gn", "HO", "bA", "Z1", "Xo", "zr", "YP", "6l", "7M", "QA", "k4", "ir", "jS", "I1", "Go", "HP", "ab", "bC", "aa", "bB", "zs", "Z2", "Xp", "YQ", "6m", "7N", "rc", "sD", "I2", "k5", "is", "jT", "Gp", "HQ", "ac", "bD", "Z3", "Xq", "zt", "YR", "80", "6n", "7O", "Pa", "rd", "sE", "QB", "k6", "it", "jU", "I3", "Gq", "HR", "ad", "bE", "zu", "Z4", "Xr", "YS", "81", "6o", "7P", "re", "sF", "Pb", "QC", "I4", "k7", "iu", "jV", "Gr", "HS", "ae", "bF", "Z5", "Xs", "zv", "YT", "82", "6p", "7Q", "Pc", "rf", "sG", "QD", "k8", "iv", "jW", "I5", "Gs", "HT", "af", "bG", "zw", "Z6", "Xt", "YU", "83", "6q", "7R", "rg", "sH", "Pd", "QE", "I6", "k9", "iw", "jX", "Gt", "HU", "ag", "bH", "Z7", "Xu", "zx", "YV", "84", "6r", "7S", "Pe", "rh", "sI", "QF", "ix", "jY", "I7", "Gu", "HV", "ah", "bI", "zy", "Z8", "Xv", "YW", "85", "6s", "7T", "ri", "sJ", "Pf", "QG", "I8", "iy", "jZ", "Gv", "HW", "ai", "bJ", "Z9", "Xw", "zz", "YX", "86", "6t", "7U", "Pg", "rj", "sK", "QH", "I9", "Gw", "HX", "aj", "bK", "Xy", "YZ", "Xx", "YY", "6u", "87", "7V", "rk", "sL", "Ph", "QI", "iz", "ak", "bL", "Xz", "6w", "7X", "89", "6v", "7W", "88", "Pi", "rl", "sM", "QJ", "Gx", "HY", "al", "bM", "6x", "7Y", "rm", "sN", "Pj", "QK", "Gy", "HZ", "am", "bN", "6y", "7Z", "t0", "Pk", "rn", "sO", "QL", "Gz", "c0", "an", "bO", "6z", "t1", "ro", "sP", "Pl", "QM", "c1", "ao", "bP", "t2", "Pm", "rp", "sQ", "QN", "kA", "c2", "ap", "bQ", "ZA", "t3", "rq", "sR", "R0", "Pn", "QO", "ja", "kB", "c3", "aq", "bR", "A0", "Ya", "ZB", "t5", "rs", "sT", "R1", "t4", "Po", "rr", "sS", "QP", "jb", "kC", "A1", "Yb", "ZC", "R3", "t6", "Pq", "rt", "sU", "QR", "R2", "Pp", "QQ", "jc", "kD", "IA", "c4", "ar", "bS", "Yc", "ZD", "8A", "t7", "ru", "sV", "R4", "Pr", "QS", "01", "00", "Ha", "jd", "kE", "IB", "c5", "as", "bT", "A2", "Yd", "ZE", "7a", "8B", "R5", "t8", "rv", "Ps", "sW", "QT", "02", "je", "kF", "Hb", "IC", "c6", "at", "bU", "A3", "Ye", "ZF", "7b", "8C", "t9", "rw", "sX", "R6", "Pt", "QU", "03", "Hc", "jf", "kG", "ID", "c7", "au", "bV", "A4", "Yf", "ZG", "7c", "8D", "R7", "rx", "sY", "Pu", "QV", "04", "jg", "kH", "Hd", "IE", "c8", "av", "bW", "A5", "Yg", "ZH", "7d", "8E", "ry", "sZ", "R8", "Pv", "QW", "05", "He", "jh", "kI", "IF", "c9", "aw", "bX", "A6", "Yh", "ZI", "7e", "8F", "R9", "rz", "Pw", "QX", "06", "ji", "kJ", "Hf", "IG", "ax", "bY", "A7", "Yi", "ZJ", "7f", "8G", "Px", "QY", "07", "jk", "kL", "Hg", "jj", "kK", "IH", "ay", "bZ", "A8", "7g", "8H", "Py", "QZ", "08", "Hi", "jl", "kM", "IJ", "Hh", "II", "az", "A9", "Yj", "ZK", "Pz", "09", "jm", "kN", "Hj", "IK", "Yk", "ZL", "7h", "8I", "l0", "jn", "Hk", "kO", "IL", "Yl", "ZM", "7i", "8J", "tA", "l1", "jo", "kP", "Hl", "IM", "Ym", "ZN", "7j", "8K", "sa", "tB", "l2", "jp", "kQ", "Hm", "IN", "Yn", "ZO", "7k", "8L", "sb", "tC", "l3", "jq", "kR", "J0", "Hn", "IO", "cA", "Yo", "ZP", "7l", "8M", "sc", "tD", "RA", "J1", "l4", "jr", "kS", "Ho", "IP", "ba", "cB", "Yp", "ZQ", "7m", "8N", "Qa", "RB", "l5", "js", "kT", "J2", "Hp", "IQ", "bc", "cD", "bb", "cC", "Yq", "ZR", "90", "7n", "8O", "sd", "tE", "J3", "l6", "jt", "kU", "Hq", "IR", "bd", "cE", "AB", "AA", "Yr", "ZS", "91", "7o", "8P", "Qb", "se", "tF", "RC", "l7", "ju", "kV", "J4", "Hr", "IS", "be", "cF", "AC", "Ys", "ZT", "92", "7p", "8Q", "sf", "tG", "Qc", "RD", "0A", "J5", "l8", "jv", "kW", "Hs", "IT", "bf", "cG", "AD", "Yt", "ZU", "93", "7q", "8R", "Qd", "sg", "tH", "RE", "0B", "l9", "jw", "kX", "J6", "Ht", "IU", "bg", "cH", "AE", "Yu", "ZV", "94", "7r", "8S", "sh", "tI", "Qe", "RF", "0C", "J7", "jx", "kY", "Hu", "IV", "bh", "cI", "AF", "Yv", "ZW", "95", "7s", "8T", "Qf", "si", "tJ", "RG", "0D", "jy", "kZ", "J8", "Hv", "IW", "bi", "cJ", "AG", "Yw", "ZX", "96", "7t", "8U", "sj", "tK", "Qg", "RH", "0E", "J9", "jz", "Hw", "IX", "bj", "cK", "AH", "Yx", "ZY", "97", "7u", "8V", "Qh", "sk", "tL", "RI", "0F", "Hx", "IY", "bk", "cL", "AI", "Yz", "Yy", "ZZ", "7v", "98", "8W", "sl", "tM", "Qi", "RJ", "0G", "bl", "cM", "AJ", "7x", "8Y", "7w", "8X", "99", "Qj", "sm", "tN", "RK", "0H", "Hy", "IZ", "bm", "cN", "AK", "7y", "8Z", "u0", "sn", "tO", "Qk", "RL", "0I", "Hz", "d0", "bn", "cO", "AL", "7z", "u1", "Ql", "so", "tP", "RM", "0J", "d1", "bo", "cP", "AM", "u2", "sp", "tQ", "Qm", "RN", "0K", "lA", "d2", "bp", "cQ", "AN", "S0", "u3", "Qn", "sq", "tR", "RO", "0L", "ka", "lB", "d3", "bq", "cR", "B0", "AO", "Za", "u4", "sr", "tS", "S1", "Qo", "RP", "0M", "kb", "lC", "d4", "br", "cS", "B1", "AP", "Zb", "u6", "st", "tU", "S2", "u5", "Qp", "ss", "tT", "RQ", "0N", "kc", "lD", "JA", "B2", "AQ", "Zc", "9A", "S4", "u7", "Qr", "su", "tV", "RS", "S3", "Qq", "RR", "10", "0O", "kd", "lE", "Ia", "JB", "d5", "bs", "cT", "Zd", "8a", "9B", "u8", "sv", "tW", "S5", "Qs", "RT", "0Q", "12", "0P", "11", "Ib", "ke", "lF", "JC", "d6", "bt", "cU", "B3", "AR", "Ze", "8b", "9C", "S6", "u9", "sw", "Qt", "tX", "RU", "0R", "13", "kf", "lG", "Ic", "JD", "d7", "bu", "cV", "B4", "AS", "Zf", "8c", "9D", "sx", "tY", "S7", "Qu", "RV", "0S", "14", "Id", "kg", "lH", "JE", "d8", "bv", "cW", "B5", "AT", "Zg", "8d", "9E", "S8", "sy", "tZ", "Qv", "RW", "0T", "15", "kh", "lI", "Ie", "JF", "d9", "bw", "cX", "B6", "AU", "Zh", "8e", "9F", "sz", "S9", "Qw", "RX", "0U", "16", "If", "ki", "lJ", "JG", "bx", "cY", "B7", "AV", "Zi", "8f", "9G", "Qx", "RY", "0V", "17", "kj", "lK", "Ig", "JH", "by", "cZ", "B8", "AW", "Zj", "8g", "9H", "Qy", "RZ", "0W", "18", "kl", "lM", "Ih", "kk", "lL", "JI", "bz", "B9", "AX", "8h", "9I", "Qz", "0X", "19", "Ij", "km", "lN", "JK", "Ii", "JJ", "AY", "Zk", "0Y", "m0", "kn", "lO", "Ik", "JL", "AZ", "Zl", "8i", "9J", "uA", "0Z", "m1", "ko", "Il", "lP", "JM", "Zm", "8j", "9K", "ta", "uB", "m2", "kp", "lQ", "Im", "JN", "Zn", "8k", "9L", "tb", "uC", "K0", "m3", "kq", "lR", "In", "JO", "dA", "Zo", "8l", "9M", "tc", "uD", "SA", "m4", "kr", "lS", "K1", "Io", "JP", "ca", "dB", "Zp", "8m", "9N", "Ra", "td", "uE", "SB", "K2", "m5", "ks", "lT", "Ip", "JQ", "cb", "dC", "Zq", "8n", "9O", "Rb", "SC", "m6", "kt", "lU", "K3", "Iq", "JR", "cd", "dE", "cc", "dD", "BA", "Zr", "8o", "9P", "te", "uF", "1A", "K4", "m7", "ku", "lV", "Ir", "JS", "ce", "dF", "Ab", "BC", "Aa", "BB", "Zs", "8p", "9Q", "Rc", "tf", "uG", "SD", "m8", "kv", "lW", "K5", "Is", "JT", "cf", "dG", "Ac", "BD", "Zt", "8q", "9R", "tg", "uH", "Rd", "SE", "0a", "1B", "K6", "m9", "kw", "lX", "It", "JU", "cg", "dH", "Ad", "BE", "Zu", "8r", "9S", "Re", "th", "uI", "SF", "0b", "1C", "kx", "lY", "K7", "Iu", "JV", "ch", "dI", "Ae", "BF", "Zv", "8s", "9T", "ti", "uJ", "Rf", "SG", "0c", "1D", "K8", "ky", "lZ", "Iv", "JW", "ci", "dJ", "Af", "BG", "Zw", "8t", "9U", "Rg", "tj", "uK", "SH", "0d", "1E", "kz", "K9", "Iw", "JX", "cj", "dK", "Ag", "BH", "Zx", "8u", "9V", "tk", "uL", "Rh", "SI", "0e", "1F", "Ix", "JY", "ck", "dL", "Ah", "BI", "Zy", "8v", "9W", "Ri", "tl", "uM", "SJ", "0f", "1G", "Iy", "JZ", "cl", "dM", "Ai", "BJ", "Zz", "8w", "9X", "tm", "uN", "Rj", "SK", "0g", "1H", "cm", "dN", "Aj", "BK", "8y", "9Z", "8x", "9Y", "v0", "Rk", "tn", "uO", "SL", "0h", "1I", "Iz", "e0", "cn", "dO", "Ak", "BL", "8z", "v1", "to", "uP", "Rl", "SM", "0i", "1J", "e1", "co", "dP", "Al", "BM", "v2", "Rm", "tp", "uQ", "SN", "0j", "1K", "mA", "e2", "cp", "dQ", "Am", "BN", "v3", "tq", "uR", "T0", "Rn", "SO", "0k", "1L", "la", "mB", "e3", "cq", "dR", "C0", "An", "BO", "T1", "v4", "Ro", "tr", "uS", "SP", "0l", "1M", "lb", "mC", "e4", "cr", "dS", "C1", "Ao", "BP", "v5", "ts", "uT", "T2", "Rp", "SQ", "0m", "1N", "lc", "mD", "KA", "e5", "cs", "dT", "C2", "Ap", "BQ", "v7", "tu", "uV", "T3", "v6", "Rq", "tt", "uU", "SR", "20", "0n", "1O", "Ja", "ld", "mE", "KB", "C3", "Aq", "BR", "9a", "T5", "v8", "Rs", "tv", "uW", "ST", "T4", "Rr", "SS", "0o", "21", "1P", "le", "mF", "Jb", "KC", "e6", "ct", "dU", "9b", "v9", "tw", "uX", "T6", "Rt", "SU", "0q", "1R", "23", "0p", "1Q", "22", "Jc", "lf", "mG", "KD", "e7", "cu", "dV", "C4", "Ar", "BS", "9c", "T7", "tx", "Ru", "uY", "SV", "0r", "1S", "24", "lg", "mH", "Jd", "KE", "e8", "cv", "dW", "C5", "As", "BT", "9d", "ty", "uZ", "T8", "Rv", "SW", "0s", "1T", "25", "Je", "lh", "mI", "KF", "e9", "cw", "dX", "C6", "At", "BU", "9e", "T9", "tz", "Rw", "SX", "0t", "1U", "26", "li", "mJ", "Jf", "KG", "cx", "dY", "C7", "Au", "BV", "9f", "Rx", "SY", "0u", "1V", "27", "Jg", "lj", "mK", "KH", "cy", "dZ", "C8", "Av", "BW", "9g", "Ry", "SZ", "0v", "1W", "28", "lk", "mL", "Jh", "KI", "cz", "C9", "Aw", "BX", "9h", "Rz", "0w", "1X", "29", "lm", "mN", "Ji", "ll", "mM", "KJ", "Ax", "BY", "9i", "0x", "1Y", "n0", "Jk", "ln", "mO", "KL", "Jj", "KK", "Ay", "BZ", "vA", "0y", "1Z", "n1", "lo", "mP", "Jl", "KM", "Az", "9j", "ua", "vB", "0z", "n2", "lp", "Jm", "mQ", "KN", "9k", "ub", "vC", "n3", "lq", "mR", "L0", "Jn", "KO", "eA", "9l", "uc", "vD", "TA", "L1", "n4", "lr", "mS", "Jo", "KP", "da", "eB", "9m", "ud", "vE", "Sa", "TB", "n5", "ls", "mT", "L2", "Jp", "KQ", "db", "eC", "9n", "Sb", "ue", "vF", "TC", "L3", "n6", "lt", "mU", "Jq", "KR", "dc", "eD", "CA", "9o", "Sc", "TD", "2A", "n7", "lu", "mV", "L4", "Jr", "KS", "de", "eF", "dd", "eE", "Ba", "CB", "9p", "uf", "vG", "1a", "2B", "L5", "n8", "lv", "mW", "Js", "KT", "df", "eG", "Bc", "CD", "Bb", "CC", "9q", "Sd", "ug", "vH", "TE", "n9", "lw", "mX", "L6", "Jt", "KU", "dg", "eH", "Bd", "CE", "9r", "uh", "vI", "Se", "TF", "1b", "2C", "L7", "lx", "mY", "Ju", "KV", "dh", "eI", "Be", "CF", "9s", "Sf", "ui", "vJ", "TG", "1c", "2D", "ly", "mZ", "L8", "Jv", "KW", "di", "eJ", "Bf", "CG", "9t", "uj", "vK", "Sg", "TH", "1d", "2E", "L9", "lz", "Jw", "KX", "dj", "eK", "Bg", "CH", "9u", "Sh", "uk", "vL", "TI", "1e", "2F", "Jx", "KY", "dk", "eL", "Bh", "CI", "9v", "ul", "vM", "Si", "TJ", "1f", "2G", "Jy", "KZ", "dl", "eM", "Bi", "CJ", "9w", "Sj", "um", "vN", "TK", "1g", "2H", "Jz", "dm", "eN", "Bj", "CK", "9x", "w0", "un", "vO", "Sk", "TL", "1h", "2I", "f0", "dn", "eO", "Bk", "CL", "9z", "9y", "w1", "Sl", "uo", "vP", "TM", "1i", "2J", "f1", "do", "eP", "Bl", "CM", "w2", "up", "vQ", "Sm", "TN", "1j", "2K", "nA", "f2", "dp", "eQ", "Bm", "CN", "U0", "w3", "Sn", "uq", "vR", "TO", "1k", "2L", "ma", "nB", "f3", "dq", "eR", "D0", "Bn", "CO", "w4", "ur", "vS", "U1", "So", "TP", "1l", "2M", "mb", "nC", "f4", "dr", "eS", "D1", "Bo", "CP", "U2", "w5", "Sp", "us", "vT", "TQ", "1m", "2N", "mc", "nD", "LA", "f5", "ds", "eT", "D2", "Bp", "CQ", "w6", "ut", "vU", "U3", "Sq", "TR", "30", "1n", "2O", "md", "nE", "Ka", "LB", "f6", "dt", "eU", "D3", "Bq", "CR", "w8", "uv", "vW", "U4", "w7", "Sr", "uu", "vV", "TS", "31", "1o", "2P", "Kb", "me", "nF", "LC", "D4", "Br", "CS", "U6", "w9", "St", "uw", "vX", "TU", "U5", "Ss", "TT", "1p", "32", "2Q", "mf", "nG", "Kc", "LD", "f7", "du", "eV", "ux", "vY", "U7", "Su", "TV", "1r", "2S", "34", "1q", "2R", "33", "Kd", "mg", "nH", "LE", "f8", "dv", "eW", "D5", "Bs", "CT", "U8", "uy", "Sv", "vZ", "TW", "1s", "2T", "35", "mh", "nI", "Ke", "LF", "f9", "dw", "eX", "D6", "Bt", "CU", "uz", "U9", "Sw", "TX", "1t", "2U", "36", "Kf", "mi", "nJ", "LG", "dx", "eY", "D7", "Bu", "CV", "Sx", "TY", "1u", "2V", "37", "mj", "nK", "Kg", "LH", "dy", "eZ", "D8", "Bv", "CW", "Sy", "TZ", "1v", "2W", "38", "Kh", "mk", "nL", "LI", "dz", "D9", "Bw", "CX", "Sz", "1w", "2X", "39", "ml", "nM", "Ki", "LJ", "Bx", "CY", "1x", "2Y", "o0", "mn", "nO", "Kj", "mm", "nN", "LK", "By", "CZ", "wA", "1y", "2Z", "o1", "Kl", "mo", "nP", "LM", "Kk", "LL", "Bz", "va", "wB", "1z", "o2", "mp", "nQ", "Km", "LN", "vb", "wC", "M0", "o3", "mq", "Kn", "nR", "LO", "fA", "vc", "wD", "UA", "o4", "mr", "nS", "M1", "Ko", "LP", "ea", "fB", "Ta", "vd", "wE", "UB", "M2", "o5", "ms", "nT", "Kp", "LQ", "eb", "fC", "ve", "wF", "Tb", "UC", "o6", "mt", "nU", "M3", "Kq", "LR", "ec", "fD", "DA", "Tc", "vf", "wG", "UD", "3A", "M4", "o7", "mu", "nV", "Kr", "LS", "ed", "fE", "Ca", "DB", "Td", "UE", "2a", "3B", "o8", "mv", "nW", "M5", "Ks", "LT", "ef", "fG", "ee", "fF", "Cb", "DC", "vg", "wH", "2b", "3C", "M6", "o9", "mw", "nX", "Kt", "LU", "eg", "fH", "Cd", "DE", "Cc", "DD", "Te", "vh", "wI", "UF", "mx", "nY", "M7", "Ku", "LV", "eh", "fI", "Ce", "DF", "vi", "wJ", "Tf", "UG", "2c", "3D", "M8", "my", "nZ", "Kv", "LW", "ei", "fJ", "Cf", "DG", "Tg", "vj", "wK", "UH", "2d", "3E", "mz", "M9", "Kw", "LX", "ej", "fK", "Cg", "DH", "vk", "wL", "Th", "UI", "2e", "3F", "Kx", "LY", "ek", "fL", "Ch", "DI", "Ti", "vl", "wM", "UJ", "2f", "3G", "Ky", "LZ", "el", "fM", "Ci", "DJ", "vm", "wN", "Tj", "UK", "2g", "3H", "Kz", "em", "fN", "Cj", "DK", "x0", "Tk", "vn", "wO", "UL", "2h", "3I", "g0", "en", "fO", "Ck", "DL", "x1", "vo", "wP", "Tl", "UM", "2i", "3J", "g1", "eo", "fP", "Cl", "DM", "x2", "Tm", "vp", "wQ", "UN", "2j", "3K", "oA", "g2", "ep", "fQ", "Cm", "DN", "x3", "vq", "wR", "V0", "Tn", "UO", "2k", "3L", "na", "oB", "g3", "eq", "fR", "E0", "Cn", "DO", "V1", "x4", "To", "vr", "wS", "UP", "2l", "3M", "nb", "oC", "g4", "er", "fS", "E1", "Co", "DP", "x5", "vs", "wT", "V2", "Tp", "UQ", "2m", "3N", "nc", "oD", "MA", "g5", "es", "fT", "E2", "Cp", "DQ", "V3", "x6", "Tq", "vt", "wU", "UR", "40", "2n", "3O", "La", "nd", "oE", "MB", "g6", "et", "fU", "E3", "Cq", "DR", "x7", "vu", "wV", "V4", "Tr", "US", "41", "2o", "3P", "ne", "oF", "Lb", "MC", "g7", "eu", "fV", "E4", "Cr", "DS", "x9", "vw", "wX", "V5", "x8", "Ts", "vv", "wW", "UT", "42", "2p", "3Q", "Lc", "nf", "oG", "MD", "E5", "Cs", "DT", "V7", "Tu", "vx", "wY", "UV", "V6", "Tt", "UU", "2q", "43", "3R", "ng", "oH", "Ld", "ME", "g8", "ev", "fW", "vy", "wZ", "V8", "Tv", "UW", "2s", "3T", "45", "2r", "3S", "44", "Le", "nh", "oI", "MF", "g9", "ew", "fX", "E6", "Ct", "DU", "V9", "vz", "Tw", "UX", "2t", "3U", "46", "ni", "oJ", "Lf", "MG", "ex", "fY", "E7", "Cu", "DV", "Tx", "UY", "2u", "3V", "47", "Lg", "nj", "oK", "MH", "ey", "fZ", "E8", "Cv", "DW", "Ty", "UZ", "2v", "3W", "48", "nk", "oL", "Lh", "MI", "ez", "E9", "Cw", "DX", "Tz", "2w", "3X", "49", "Li", "nl", "oM", "MJ", "Cx", "DY", "2x", "3Y", "nm", "oN", "Lj", "MK", "Cy", "DZ", "xA", "2y", "3Z", "p1", "no", "oP", "p0", "Lk", "nn", "oO", "ML", "Cz", "wa", "xB", "2z", "p2", "Lm", "np", "oQ", "MN", "Ll", "MM", "wb", "xC", "p3", "nq", "oR", "N0", "Ln", "MO", "gA", "wc", "xD", "VA", "N1", "p4", "nr", "Lo", "oS", "MP", "fa", "gB", "wd", "xE", "Ua", "VB", "p5", "ns", "oT", "N2", "Lp", "MQ", "fb", "gC", "Ub", "we", "xF", "VC", "N3", "p6", "nt", "oU", "Lq", "MR", "fc", "gD", "EA", "wf", "xG", "Uc", "VD", "4A", "p7", "nu", "oV", "N4", "Lr", "MS", "fd", "gE", "Da", "EB", "Ud", "wg", "xH", "VE", "3a", "4B", "N5", "p8", "nv", "oW", "Ls", "MT", "fe", "gF", "Db", "EC"};

    public static void main(String[] args) {



////        String arr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String arr = "0123456789ABCDEF";
//        Set builder = new HashSet<>();
//
//        for (int i = 0; i < arr.length(); i++) {
//
//            for (int k = 0; k < arr.length(); k++) {
//                builder.add("\"" + arr.substring(i,i+1) +arr.substring(k,k+1) + "\"");
//                builder.add("\"" +arr.substring(k,k+1) +arr.substring(i,i+1)+ "\"");
//            }
//
//        }
//
//
//        System.out.println(builder);
    };
    public static  int randomInt(int min, int max) {
        if (min == max) return min;
        return new Random().nextInt(max) + min;
    }
    public  static  String randomWifiInfoBSSID() {
        String[] strings = new String[]{"5E", "F6", "4C", "E4", "D2", "3A", "C0", "79", "67", "66", "FF", "54", "ED", "42", "DB", "30", "4D", "E5", "3B", "D3", "C1", "68", "56", "EF", "55", "EE", "43", "DC", "31", "CA", "5F", "F7", "3C", "D4", "2A", "C2", "B0", "69", "57", "45", "DE", "44", "DD", "32", "CB", "20", "F8", "4E", "E6", "2B", "C3", "B1", "58", "46", "DF", "34", "CD", "33", "CC", "21", "BA", "F9", "4F", "E7", "3D", "D5", "1A", "B2", "A0", "9A", "59", "47", "35", "CE", "23", "BC", "22", "BB", "10", "90", "E8", "3E", "D6", "2C", "C4", "A1", "9B", "48", "36", "CF", "24", "BD", "12", "AB", "11", "AA", "91", "E9", "3F", "D7", "2D", "C5", "1B", "B3", "9C", "8A", "49", "37", "25", "BE", "13", "AC", "01", "00", "92", "80", "D8", "2E", "C6", "1C", "B4", "0A", "A2", "9D", "8B", "38", "26", "BF", "14", "AD", "02", "93", "81", "D9", "2F", "C7", "1D", "B5", "0B", "A3", "9E", "8C", "7A", "39", "27", "15", "AE", "03", "94", "82", "70", "C8", "1E", "B6", "0C", "A4", "9F", "8D", "7B", "28", "16", "AF", "04", "95", "83", "71", "C9", "1F", "B7", "0D", "A5", "8E", "7C", "6A", "F0", "29", "17", "05", "96", "84", "72", "60", "B8", "0E", "A6", "8F", "7D", "6B", "F1", "18", "06", "97", "85", "73", "61", "FA", "B9", "0F", "A7", "7E", "6C", "F2", "5A", "E0", "19", "07", "98", "86", "74", "62", "FB", "50", "A8", "7F", "6D", "F3", "5B", "E1", "08", "99", "87", "75", "63", "FC", "51", "EA", "A9", "6E", "F4", "5C", "E2", "4A", "D0", "09", "89", "88", "76", "64", "FD", "52", "EB", "40", "6F", "5D", "F5", "E3", "4B", "D1", "78", "77", "65", "FE", "53", "EC", "41", "DA"};
        return strings[randomInt(0, strings.length - 1)] + ":" +
                strings[randomInt(0, strings.length - 1)] + ":"
                + strings[randomInt(0, strings.length - 1)]
                + ":" + strings[randomInt(0, strings.length - 1)]
                + ":" + strings[randomInt(0, strings.length - 1)]
                + ":" + strings[randomInt(0, strings.length - 1)];

    }

    /**
     * 加密
     *
     * @param ip 待加密的Ip
     * @return
     */
    public static String encode(String ip) {
        StringBuilder builder = new StringBuilder();
        String[] ipArr = ip.split("\\.");
        int length = ipArr.length;
        for (int index = 0; index < length; index++) {
            builder.append(hex[Integer.parseInt(ipArr[index]) + index * 255]);
        }
        builder.append(hex[ThreadLocalRandom.current().nextInt(hex.length)]);
        return builder.toString();
    }


    /**
     * 加密
     *
     * @param data 加密的Ip
     * @return
     */
    public static String decode(String data) {
        Map<Integer, Integer> map = new HashMap<>();
        String ip1 = data.substring(0, 2);
        String ip2 = data.substring(2, 4);
        String ip3 = data.substring(4, 6);
        String ip4 = data.substring(6, 8);
        int totalLength = hex.length;
        for (int index = 0; index < totalLength; index++) {
            if (hex[index].equals(ip1)) {
                map.put(1, index);
            } else if (hex[index].equals(ip2)) {
                map.put(2, index - 1 * 255);
            } else if (hex[index].equals(ip3)) {
                map.put(3, index - 2 * 255);
            } else if (hex[index].equals(ip4)) {
                map.put(4, index - 3 * 255);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Integer val : map.values()) {
            if (builder.length() > 0) {
                builder.append(".");
            }
            builder.append(val);
        }
        return builder.toString();
    }


}
