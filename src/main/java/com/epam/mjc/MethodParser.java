package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String accessModifier, returnType, methodName;
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        String[] words = signatureString.split("[,() ]+");
        if (words[0].equals("public") || words[0].equals("private") || words[0].equals("protected")) {
            accessModifier = words[0];
            returnType = words[1];
            methodName = words[2];

            for (int i = 3; i < words.length - 1; i += 2) {
                arguments.add(new MethodSignature.Argument(words[i], words[i + 1]));
            }
        }
        else {
            accessModifier = "";
            returnType = words[0];
            methodName = words[1];

            for (int i = 2; i < words.length - 1; i += 2) {
                arguments.add(new MethodSignature.Argument(words[i], words[i + 1]));
            }
        }

        MethodSignature signature = new MethodSignature(methodName, arguments);
        if (!accessModifier.isEmpty()) {
            signature.setAccessModifier(accessModifier);
        }
        signature.setReturnType(returnType);
        return signature;
    }
}
