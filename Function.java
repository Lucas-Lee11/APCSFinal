import java.util.*;

public class Function{

    private Complex[] terms;

    public Function(Complex[] terms){
        if(terms.length != 5) throw new IllegalArgumentException();
        this.terms = terms;
    }

    public Complex[] getRoots(){
        Complex A = terms[0]; Complex B = terms[1]; Complex C = terms[2]; Complex D = terms[3]; Complex E = terms[4];

        Complex al = Complex.sub(
            Complex.div(C,A),
            Complex.div(
                Complex.mult(
                    new Complex(3),
                    Complex.pow(B, new Complex(2))
                ),
                Complex.mult(
                    new Complex(8),
                    Complex.pow(A, new Complex(2))
                )
            )
        );
        Complex be = Complex.sub(
            Complex.div(
                Complex.pow(B,new Complex(3)),
                Complex.mult(
                    new Complex(8),
                    Complex.pow(A, new Complex(3))
                )
            ),
            Complex.div(
                Complex.mult(B,C),
                Complex.mult(
                    new Complex(2),
                    Complex.pow(A, new Complex(2))
                )
            )
        );
        be = Complex.add(be,
            Complex.div(D,A)
        );

        Complex ga1 = Complex.sub(
            Complex.div(
                Complex.mult(
                    C,
                    Complex.pow(B, new Complex(2))
                ),
                Complex.mult(
                    new Complex(16),
                    Complex.pow(A, new Complex(3))
                )
            ),
            Complex.div(
                Complex.mult(
                    new Complex(3),
                    Complex.pow(B, new Complex(4))
                ),
                Complex.mult(
                    new Complex(256),
                    Complex.pow(A, new Complex(4))
                )
            )
        );
        Complex ga2 = Complex.sub(
            Complex.div(E,A),
            Complex.div(
                Complex.mult(B,D),
                Complex.mult(
                    new Complex(4),
                    Complex.pow(A, new Complex(2))
                )
            )
        );
        Complex ga = Complex.add(ga1, ga2);

        if(be.equals(new Complex(0,0))){
            Complex[] roots = new Complex[4];
            for(int i = 0; i <= 3; i ++){
                int s = (int) Math.pow(-1, i);
                int t = (i/2 * 2) -1;

                Complex con = Complex.div(Complex.mult(new Complex(-1), B), Complex.mult(new Complex(4), A));
                Complex dis = Complex.sqrt(Complex.sub(Complex.pow(al, new Complex(2)), Complex.mult(new Complex(4), ga)));
                dis = Complex.mult(dis, new Complex(t));
                dis = Complex.add(Complex.mult(new Complex(-1), al), dis);
                dis = Complex.mult(new Complex(s), Complex.sqrt(Complex.div(dis, new Complex(2))));
                roots[i] = Complex.add(con, dis);
            }
            return roots;
        }

        Complex P = Complex.add(
            Complex.div(
                Complex.pow(al,new Complex(2)),
                new Complex(12)
            ),
            ga
        );
        P = Complex.mult(new Complex(-1), P);

        Complex Q = Complex.sub(
            Complex.div(
                Complex.mult(al, ga),
                new Complex(3)
            ),
            Complex.div(
                Complex.pow(be, new Complex(2)),
                new Complex(8)
            )
        );
        Q = Complex.sub(Q,
            Complex.div(Complex.pow(al, new Complex(3)), new Complex(108))
        );

        Complex R = Complex.add(
            Complex.div(Complex.pow(Q, new Complex(2)), new Complex(4)),
            Complex.div(
                Complex.pow(P, new Complex(3)),
                new Complex(27)
            )
        );
        R = Complex.sub(
            Complex.sqrt(R),
            Complex.div(Q, new Complex(2))
        );

        Complex U = Complex.pow(R, new Complex(1.0/3.0));

        Complex y = Complex.mult(new Complex(-5.0/6.0), al);
        if(U.equals(new Complex(0))) y = Complex.sub(y, Complex.pow(Q, new Complex(1.0/3.0)));
        else {
            y = Complex.sub(
                y,
                Complex.div(P, Complex.mult(new Complex(3), U))
            );
            y = Complex.add(y, U);
        }

        Complex W = Complex.sqrt(Complex.add(al, Complex.mult(new Complex(2), y)));

        Complex[] roots = new Complex[4];
        for(int i = 0; i <= 3; i++){
            int s = (int) Math.pow(-1, i);
            int t = (i/2 * 2) -1;

            Complex out = Complex.mult(
                new Complex(s),
                Complex.div(
                    Complex.mult(new Complex(2), be),
                    W
                )
            );
            out = Complex.add(
                Complex.add(
                    Complex.mult(new Complex(3), al),
                    Complex.mult(new Complex(2), y)
                ),
                out
            );
            out = Complex.mult(new Complex(t), Complex.sqrt(Complex.mult(new Complex(-1), out)));
            out = Complex.div(
                Complex.add(
                    Complex.mult(new Complex(s), W),
                    out
                ),
                new Complex(2)
            );
            out = Complex.sub(
                out,
                Complex.div(
                    B,
                    Complex.mult(new Complex(4), A)
                )
            );
            roots[i] = out;
        }

        return roots;
    }

    

    public static void main(String[] args) {
        Function f = new Function(new Complex[]{
            new Complex(2,3),
            new Complex(-3,4),
            new Complex(34,0),
            new Complex(-3,-10),
            new Complex(0,-5)
        });

        Complex[] rts = f.getRoots();
        for(Complex rt: rts) System.out.println(rt);

        System.out.println(new Complex(12,0.001).equals(new Complex(12)));
    }
}
