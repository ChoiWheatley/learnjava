package ch12;

import java.util.ArrayList;
import java.util.List;

public class WildcardUsecases {

    public static class SubTyping {
        public static void pseudomain() {
            List<EvenNumber> evenNumbers = new ArrayList<>();
            evenNumbers.add(new EvenNumber(1));
            List<? extends NaturalNumber> naturalNumbers = evenNumbers; // OK
            // naturalNumbers.add(new NaturalNumber(0)); // Compile Error. 말도 안된다.
            // naturalNumbers.add(new EvenNumber(0)); // Compile Error. 얘는 왜 안되냐?
            naturalNumbers.add(null); // OK
            naturalNumbers.clear(); // OK
        }

        public static class NaturalNumber {
            public NaturalNumber(int i) {
            }
        }

        public static class EvenNumber extends NaturalNumber {
            public EvenNumber(int i) {
                super(i);
            }
        }
    }

    public static class WildcardCapture {
        <T> void foo(List<T> i) {
            i.set(0, i.get(0)); // OK, i의 타입은 T임을 추론할 수 있음.
        }

        void bar(List<?> i) {
            /**
             * actual argument Object cannot be converted to CAP#1 by method invocation
             * conversion where E is a type-variable: E extends Object declared in interface
             * List where CAP#1 is a fresh type-variable:
             * CAP#1 extends Object from capture of ?
             * 대충 컴파일러가 이건 safe하지 않다고 말한다.
             */
            // i.set(0, i.get(0)); // Compile Error,
            foo(i); // OK, 와일드카드를 캡쳐하면 가능.
        }
    }
}
