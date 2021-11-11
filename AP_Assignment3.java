package sem2;

import java.io.*;
import java.util.*;
interface MatrixTypes{
    Matrix check(Matrix m);
    float [][] formN(int R,int C);
}
class Matrix{
    Scanner sc = new Scanner(System.in);
    protected String m;
    protected int c = 1,r = 1;
    protected float [][] matrix;
    protected String temp = "";
    Matrix(){}
    ArrayList<Object> status = new ArrayList<>();
    Matrix setM(String m) {
        this.m = m;
        return this;
    }
    public Matrix form(){
        int i = 0;
        while(i<this.m.length()){
            if(this.m.charAt(i) == ';'){
                this.c = 1;
                this.r = this.r + 1;
            }
            else if(this.m.charAt(i) == ','){
                this.c = this.c + 1;
            }
            i++;
        }
        this.matrix = new float[this.r][this.c];
        i = 0;
        int j = 0;
        int l = 0;
        while(l < this.m.length()){
            if(this.m.charAt(l) == ',' || this.m.charAt(l) == ']' || this.m.charAt(l) == ';'){
                int k = l-1;
                this.temp = "";
                while(this.m.charAt(k) != ',' && this.m.charAt(k) != '[' && this.m.charAt(k) != ';'){
                    this.temp += this.m.charAt(k);
                    k = k - 1;
                }
                this.matrix[j][i] = Integer.parseInt(this.temp);
                i++;
            }
            if(this.m.charAt(l) == ';') {
                j = j + 1;
                i = 0;
            }
            l++;
        }
        return this;
    }
    public Matrix checkO(Matrix m){
        SingletonMatrix m13 = new SingletonMatrix();
        OnesMatrix m14 = new OnesMatrix();
        NullMatrix m15 = new NullMatrix();
        IdentityMatrix m12 = new IdentityMatrix();
        ScalarMatrix m11 = new ScalarMatrix();
        DiagonalMatrix m10 = new DiagonalMatrix();
        UpperTriangularMatrix m7 = new UpperTriangularMatrix();
        LowerTriangularMatrix m8 = new LowerTriangularMatrix();
        SymmetricMatrix m5 = new SymmetricMatrix();
        SkewSymmetricMatrix m6 = new SkewSymmetricMatrix();
        SingularMatrix m9 = new SingularMatrix();
        RectangularMatrix m1 = new RectangularMatrix();
        RowMatrix m2 = new RowMatrix();
        ColumnMatrix m3 = new ColumnMatrix();
        SquareMatrix m4 =  new SquareMatrix();
        m15.check(m);
        m13.check(m);
        m14.check(m);
        m12.check(m);
        m11.check(m);
        m10.check(m);
        m9.check(m);
        m8.check(m);
        m7.check(m);
        m6.check(m);
        m5.check(m);
        m4.check(m);
        m2.check(m);
        m3.check(m);
        m1.check(m);
        return m;
    }
    protected float [][] inverse = new float[this.r][this.c];
    public void formInverse(float [][] i){
        this.inverse = i;
    }
}

class RectangularMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
        if(m.c!=m.r){
        m.status.add(this);
        }
        return m;
    }
    @Override
    public float [][] formN(int R, int C){
        r = R;
        c = C;
        matrix = new float[r][c];
        System.out.println("Enter the matrix values: ");
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
}
class RowMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
        if(m.r == 1 && m.c != 1){
            m.status.add(this);
        }
        return m;
    }
    @Override
    public float [][] formN(int C,int R){
        c = C;
        matrix = new float[1][c];
        System.out.println("Enter the matrix values: ");
        for(int j = 0;j<c;j++){
            matrix[0][j] = sc.nextInt();
        }
        return matrix;
    }
}
class ColumnMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
        if(m.c == 1 && m.r != 1){
            m.status.add(this);
        }
        return m;
    }
    @Override
    public float [][] formN(int C, int R) {
        r = R;
        matrix = new float[r][1];
        System.out.println("Enter the matrix values: ");
        for (int j = 0; j < r; j++) {
            matrix[j][0] = sc.nextInt();
        }
        return matrix;
    }
}
class SquareMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
        if (m.c == m.r && m.r != 1) {
            m.status.add(this);
        }
        return m;
    }
    @Override
    public float [][] formN(int R,int C){
        this.r = R;
        this.c = C;
        this.matrix = new float[r][c];
        System.out.println("Enter the matrix values: ");
        for (int i = 0; i < this.r; i++) {
            for (int j = 0; j < this.c; j++) {
                this.matrix[i][j] = sc.nextInt();
            }
        }
        return this.matrix;
    }
}
class SymmetricMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
        if(m.r != 1 && m.c != 1 ) {
            float[][] transpose = new float[m.c][m.r];
            for (int i = 0; i < m.r; i++) {
                for (int j = 0; j < m.c; j++) {
                    transpose[j][i] = m.matrix[i][j];
                }
            }
            int flag = 1;
            if (m.r == m.c) {
                for (int i = 0; i < m.r; i++) {
                    for (int j = 0; j < m.c; j++) {
                        if (m.matrix[i][j] != transpose[i][j]) {
                            flag = 0;
                            break;
                        }
                    }
                }
                if (flag == 1) {
                    m.status.add(this);
                }
            }
        }
        return m;
    }
    @Override
    public float [][] formN(int R, int C) {
        if (R == C) {
            this.matrix = new float[R][C];
            System.out.println("Enter the matrix values for only upper side and diagonal: ");
            for (int i = 0; i < r; i++) {
                for (int j = i; j < c; j++) {
                    matrix[i][j] = sc.nextInt();
                    matrix[j][i] = matrix[i][j];
                }
            }
            return matrix;
        }
        return null;
    }
}
class SkewSymmetricMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m) {
        if(m.r != 1 && m.c != 1 ) {
            int flag = 0;
            float[][] transpose = new float[m.c][m.r];
            for (int i = 0; i < m.r; i++) {
                for (int j = 0; j < m.c; j++) {
                    transpose[j][i] = m.matrix[i][j];
                }
            }
            for (int i = 0; i < m.r; i++) {
                for (int j = 0; j < m.c; j++) {
                    if (transpose[i][j] + m.matrix[i][j] != 0) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                m.status.add(this);
            }
        }
        return m;
    }
    @Override
    public float [][] formN(int R, int C){
        if(R == C){
        matrix = new float[R][C];
        System.out.println("Enter the matrix values for only upper side ");
        for(int i = 0;i<r;i++){
            for(int j = i+1;j<c;j++){
                if(i == j){
                    matrix[i][j] = 0;
                }
                else {
                    matrix[i][j] = sc.nextInt();
                    matrix[j][i] = -matrix[i][j];
                }
            }
        }
        return matrix;
        }
        else{
            System.out.println("Wrong matrix dimensions");
            return null;
        }
    }
}
class UpperTriangularMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m) {
        if(m.r != 1 && m.c != 1 ) {
            int flag = 0;
            for (int i = 1; i < m.r; i++) {
                for (int j = 0; j < i; j++) {
                    if (m.matrix[i][j] != 0) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                m.status.add(this);
            }
        }
        return m;
    }
    @Override
    public float [][] formN(int R, int C){
        matrix = new float[R][C];
        if(R == C){
            for(int i = 0;i<R;i++){
                for(int j = 0;j<C;j++){
                    if(i>j) {
                        matrix[i][j] = 0;
                    }
                    else{
                        matrix[i][j] = sc.nextInt();
                    }
                }
            }
            return matrix;
        }
        else{
            System.out.println("Wrong dimensions");
            return null;
        }
    }
}
class LowerTriangularMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
        if(m.r != 1 && m.c != 1 ) {
            int flag = 0;
            for (int i = 0; i < m.r; i++) {
                for (int j = i + 1; j < m.r; j++) {
                    if (m.matrix[i][j] != 0) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                m.status.add(this);
            }
        }
        return m;
    }
    @Override
    public float [][] formN(int R, int C){
        matrix = new float[R][C];
        if(R == C){
            for(int i = 0;i<R;i++){
                for(int j = 0;j<C;j++){
                    if(i<j) {
                        matrix[i][j] = 0;
                    }
                    else{
                        matrix[i][j] = sc.nextInt();
                    }
                }
            }
            return matrix;
        }
        else{
            System.out.println("matrix can't be formed");
            return null;
        }
    }
}
class SingularMatrix extends Matrix implements MatrixTypes{
    private void getCofactor(float[][] mat, float[][] temp, int l, int m,int N) {
        int i = 0, j = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (row != l && col != m) {
                    temp[i][j++] = mat[row][col];
                    if (j == N - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    private float isSingular(float [][] matrix,int N) {
        int flag = 0;
        if (N == 1) {
            return matrix[0][0];
        }
        float [][] temp = new float[N][N];
        int sign = 1;
        for (int f = 0; f < N; f++) {
            getCofactor(matrix, temp, 0, f,N);
            flag += sign * matrix[0][f] * isSingular(temp, N - 1);
            sign = -sign;
        }
        return flag;
    }
    @Override
    public Matrix check(Matrix m){
        if(m.r != 1 && m.c != 1 ) {
            if (isSingular(m.matrix, m.r) == 1) {
                m.status.add(this);
            }
        }
        return m;
    }
    @Override
    public float [][] formN(int R, int C){
        if(R == C) {
            matrix = new float[R][C];
            float [][] temp = new float[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    temp[i][j] = sc.nextInt();
                }
            }
            if (isSingular(temp, r) != 1) {
                System.out.println("matrix is not singular");
                return null;
            } else {
                matrix = temp;
                return matrix;
            }
        }
        else{
            System.out.println("matrix can't be formed");
            return null;
        }
    }
}
class DiagonalMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
        if(m.r != 1 && m.c != 1 ) {
            int flag = 0;
            for (int i = 0; i < m.r; i++) {
                for (int j = 0; j < m.c; j++) {
                    if ((i != j) && (m.matrix[i][j] != 0)) {
                        flag = 1;
                        break;
                    }
                }
            }
            if (flag == 0) {
                m.status.add(this);
            }
        }
        return m;
    }
    @Override
    public float [][] formN(int R, int C){
        if(R == C){
            matrix = new float[R][C];
            System.out.println("Enter the diagonal elements");
            for(int i = 0;i<R;i++){
                for(int j = 0;j<C;j++){
                    if(i == j) {
                        matrix[i][j] = sc.nextInt();
                    }else{
                        matrix[i][j] = 0;
                    }
                }
            }
            return matrix;
        }
        else{
            System.out.println("Matrix can't be formed");
            return null;
        }
    }
}
class ScalarMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m) {
        if(m.r != 1 && m.c != 1 ) {
            int flag1 = 0, flag2 = 0;
            for (int i = 0; i < m.r; i++) {
                for (int j = 0; j < m.c; j++) {
                    if ((i != j) && (m.matrix[i][j] != 0)) {
                        flag1 = 1;
                        break;
                    }
                }
            }
            for (int i = 0; i < m.r - 1; i++) {
                if (m.matrix[i][i] != m.matrix[i + 1][i + 1]) {
                    flag2 = 1;
                    break;
                }
            }
            if (flag1 == 0 && flag2 == 0) {
                m.status.add(this);
            }
        }
        return m;
    }
    @Override
    public float [][] formN(int R, int C) {
        if (R == C) {
            System.out.println("enter the diagonal element(note all the elements will be of same value):");
            int num = sc.nextInt();
            matrix = new float[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (i == j) {
                        matrix[i][j] = num;
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }
            return matrix;
        } else {
            System.out.println("Matrix can't be formed");
            return null;
        }
    }
}
class IdentityMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
        if(m.r!=1 && m.c!=1) {
            int flag1 = 0, flag2 = 0;
            for (int i = 0; i < m.r; i++) {
                for (int j = 0; j < m.c; j++) {
                    if (i == c && m.matrix[r][c] != 1) {
                        flag1 = 1;
                    } else if (i != j && m.matrix[i][j] != 0) {
                        flag2 = 1;
                    }
                }
            }
            if (flag1 == 0 && flag2 == 0) {
                m.status.add(this);
            }
        }
        return m;
    }

    @Override
    public float [][] formN(int R, int C){
        if (R==C){
            matrix = new float[R][C];
            for(int i = 0;i<R;i++){
                for(int j = 0;j<C;j++){
                    if(i == j) {
                        matrix[i][j] = 1;
                    }
                    else{
                        matrix[i][j] = 0;
                    }
                }
            }
            return matrix;
        }
        else{
            System.out.println("Wrong Dimensions");
            return null;
        }
    }
}
class SingletonMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
        if(m.r == 1 && m.c == 1){
            m.status.add(this);
        }
        return m;
    }
    @Override
    public float [][] formN(int R,int C){
        if(R == 1 && C==1) {
            System.out.println("enter the element:");
            matrix = new float[1][1];
            matrix[0][0] = sc.nextInt();
            return matrix;
        }
        else{
            System.out.println("not a singleton matrix");
            return null;
        }
    }
}
class OnesMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
            int flag = 1;
            for (int i = 0; i < m.r; i++) {
                for (int j = 0; j < m.c; j++) {
                    if (m.matrix[i][j] != 1) {
                        flag = 0;
                        break;
                    }
                }
            }
            if (flag == 1) {
                m.status.add(this);
            }
        return m;
    }
    @Override
    public float [][] formN(int R, int C){
        matrix = new float[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }
}
class NullMatrix extends Matrix implements MatrixTypes{
    @Override
    public Matrix check(Matrix m){
        int flag = 1;
        for(int i = 0; i<m.r; i++){
            for(int j = 0; j<m.c; j++){
                if(m.matrix[i][j] != 0) {
                    flag = 0;
                    break;
                }
            }
        }
        if(flag == 1){
            m.status.add(this);
        }
        return m;
    }
    @Override
    public float [][] formN(int R, int C){
        r = R;
        c = C;
        matrix = new float[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }
}

class MatrixOperations{
    void display (float[][] A){
        for (int i = 0; i < A.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < A[i].length; j++)
                System.out.printf("%.4f ",A[i][j]);
            System.out.println();
        }
    }
    Matrix Transpose(Matrix m){
        float [][] transpose = new float[m.c][m.r];
        for (int i = 0; i < m.r; i++) {
            for (int j = 0; j < m.c; j++) {
                transpose[j][i] = m.matrix[i][j];
            }
        }
        m.matrix = transpose;
        display(m.matrix);
        return m;
    }
    void Addition(Matrix m1, Matrix m2){
        float [][] temp = new float[m1.r][m1.c];
        if(m1.r == m2.r && m1.c == m2.c) {
            for (int i = 0; i < m1.r; i++) {
                for (int j = 0; j < m1.c; j++) {
                    temp[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
                }
            }
            System.out.println("ans = ");
            display(temp);
        }
        else{
            System.out.println("Dimensions of the matrix are not compatible");
        }
    }
    void Subtraction(Matrix m1, Matrix m2){
        float [][] temp = new float[m1.r][m1.c];
        if(m1.r == m2.r && m1.c == m2.c) {
            for (int i = 0; i < m1.r; i++) {
                for (int j = 0; j < m1.c; j++) {
                    temp[i][j] = m1.matrix[i][j] - m2.matrix[i][j];
                }
            }
            System.out.println("ans = ");
            display(temp);
        }
        else{
            System.out.println("Dimensions of the matrices are not compatible");
        }
    }
    void Multiplication(Matrix m1, Matrix m2) {
        int flagN1 = 0, flagN2 = 0;
        float [][] temp = new float[m1.r][m2.c];
        for (int k = 0; k < m1.status.size(); k++) {
            if (m1.status.get(k) instanceof NullMatrix) {
                flagN1 = 1;
                for (int i = 0; i < m1.r; i++) {
                    for (int j = 0; j < m2.c; j++) {
                        temp[i][j] = 0;
                    }
                }
                System.out.println("ans = ");
                display(temp);
                break;
            }
        }
        if(flagN1 == 0) {
            for (int k = 0; k < m2.status.size(); k++) {
                if (m2.status.get(k) instanceof NullMatrix) {
                    flagN2 = 1;
                    for (int i = 0; i < m1.r; i++) {
                        for (int j = 0; j < m2.c; j++) {
                            temp[i][j] = 0;
                        }
                    }
                    System.out.println("ans = ");
                    display(temp);
                    break;
                }
            }
        }
        if (flagN1 == 0 && flagN2 == 0) {
            for (int k = 0; k < m1.status.size(); k++) {
                if (m1.status.get(k) instanceof IdentityMatrix) {
                    flagN1 = 1;
                    temp = m2.matrix;
                    break;
                }
            }
            for (int k = 0; k < m2.status.size(); k++) {
                if (m2.status.get(k) instanceof IdentityMatrix) {
                    flagN2 = 1;
                    temp = m1.matrix;
                    break;
                }
            }
            System.out.println("ans = ");
            display(temp);
        }
        if (flagN1 == 0 && flagN2 == 0) {
            if (m1.c == m2.r) {
                for (int i = 0; i < m1.r; i++) {
                    for (int j = 0; j < m2.c; j++) {
                        temp[i][j] = 0;
                        for (int k = 0; k < m1.c; k++) {
                            temp[i][j] += m1.matrix[i][k] * m2.matrix[k][j];
                        }
                    }
                }
                System.out.println("ans = ");
                display(temp);
            }
            else {
                System.out.println("Dimensions of the matrices are not compatible");
            }
        }
    }
    private void getCofactor(float[][] A, float[][] temp, int l, int m, int n){
        int i = 0, j = 0;
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                if (row != l && col != m)
                {
                    temp[i][j++] = A[row][col];
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    float determinant(float [][] m, int n){
        float D = 0;
        if (n == 1) {
            return m[0][0];
        }
        float [][]temp = new float[m.length][m.length];
        int sign = 1;
        for (int f = 0; f < n; f++) {
            getCofactor(m, temp, 0, f, n);
            D += sign * m[0][f] * determinant(temp, n - 1);
            sign = -sign;
        }
        return D;
    }
    private void Ad_joint(Matrix m, float [][] adj){
        if (m.r == 1)
        {
            adj[0][0] = 1;
            return;
        }
        int sign;
        float [][]temp = new float[m.r][m.c];

        for (int i = 0; i < m.r; i++)
        {
            for (int j = 0; j < m.c; j++)
            {
                getCofactor(m.matrix, temp, i, j, m.r);
                sign = ((i + j) % 2 == 0)? 1: -1;
                adj[j][i] = (sign)*(determinant(temp, m.r-1));
            }
        }
    }
    void InverseMatrix(Matrix m) {
        if (m.r == m.c) {
            float det = determinant(m.matrix, m.r);
            if (det == 0) {
                System.out.print("Singular matrix, can't find its inverse");
            }
            float [][] adj = new float[m.r][m.c];
            Ad_joint(m, adj);
            float[][] inverse = new float[m.r][m.c];
            for (int i = 0; i < m.r; i++) {
                for (int j = 0; j < m.c; j++) {
                    inverse[i][j] = adj[i][j] / det;
                }
            }
            m.formInverse(inverse);
            display(inverse);
        }
        else{
            System.out.println("Matrix Dimensions are not compatible");
        }
    }
    void Division(Matrix m1, Matrix m2) {
        if (m2.r == m2.c) {
            float det = determinant(m2.matrix, m2.r);
            if (det == 0) {
                System.out.print("Determinant zero, can't perform division");
            }
            float[][] adj = new float[m2.r][m2.c];
            Ad_joint(m2, adj);
            float[][] inverse = new float[m2.r][m2.c];
            for (int i = 0; i < m2.r; i++) {
                for (int j = 0; j < m2.c; j++) {
                    inverse[i][j] = adj[i][j] / det;
                }
            }
            m2.matrix = inverse;
            Multiplication(m1, m2);
        } else {
            System.out.println("Matrix Dimensions are not compatible");
        }
    }
    void EleMultiplication(Matrix m1,Matrix m2) {
        float[][] temp = new float[m1.r][m1.c];
        if ((m1 instanceof NullMatrix) || (m2 instanceof NullMatrix)) {
            for (int i = 0; i < m1.r; i++) {
                for (int j = 0; j < m1.c; j++) {
                    temp[i][j] = 0;
                }
            }
            System.out.println("ans = ");
            display(temp);
        } else {
            if (m1.r == m2.r && m1.c == m2.c) {
                for (int i = 0; i < m1.r; i++) {
                    for (int j = 0; j < m1.c; j++) {
                        temp[i][j] = m1.matrix[i][j] * m2.matrix[i][j];
                    }
                }
                System.out.println("ans = ");
                display(temp);
            }
            else {
                System.out.println("Dimensions of the matrix are not compatible");
            }
        }
    }
    void EleDivision(Matrix m1, Matrix m2) {
        if (m1.r == m2.r && m1.c == m2.c) {
            float [][] temp = new float[m1.r][m1.c];
            int flag = 0;
            for (int i = 0; i < m2.r; i++) {
                for (int j = 0; j < m2.c; j++) {
                    if (m2.matrix[i][j] == 0) {
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 0){
                for (int i = 0; i < m1.r; i++) {
                    for (int j = 0; j < m1.c; j++) {
                        temp[i][j] = m1.matrix[i][j] * m2.matrix[i][j];
                    }
                }
                System.out.println("ans = ");
                display(temp);
            }
            else{
                System.out.println("Zero denominator can't perform operation");
            }
        }
        else{
            System.out.println("Dimensions of the matrix are not compatible");
        }
    }
    void AddTranspose(Matrix m){
        Matrix transpose = Transpose(m);
        Addition(m,transpose);
    }
    float mean(float [] a){
        float sum = 0;
        for(int i = 0;i<a.length;i++){
            sum += a[i];
        }
        return sum;
    }
    void RowMean(Matrix m){
        for(int i = 0;i<m.r;i++){
            System.out.print(mean(m.matrix[i])/m.c + " ");
        }
    }
    void ColumnMean(Matrix m){
        for(int i = 0;i<m.c;i++){
            float sum = 0;
            for(int j = 0;j<m.r;j++){
                sum += m.matrix[j][i];
            }
            System.out.print(sum/m.r + " ");
        }
    }
    void EleMean(Matrix m){
        float sum = 0;
        for(int i = 0;i<m.r;i++){
            for(int j = 0;j<m.c;j++){
                sum += m.matrix[i][j];
            }
        }
        System.out.println(sum/(m.r*m.c));
    }
    void SolveMatrix(Matrix m1, Matrix m2){

        Division(m1,m2);
    }
    void Task11(Matrix m1, Matrix m2,String op){
        float[][] temp = new float[m2.r][m2.c];
        if(op.equals("*")){
            for (int i = 0; i < m2.r; i++) {
                for (int j = 0; j < m2.c; j++) {
                    temp[i][j] = m1.matrix[0][0] * m2.matrix[i][j];
                }
            }
        }
        else{
            for (int i = 0; i < m2.r; i++) {
                for (int j = 0; j < m2.c; j++) {
                    temp[i][j] = m2.matrix[i][j] / m1.matrix[0][0];
                }
            }
        }
        System.out.println("ans = ");
        display(temp);
    }
    void Task15(ArrayList<Matrix> a,String s){
        String condition;
        for(int i = 0;i<a.size();i++){
            Matrix m = a.get(i);
            for(int j = 0;j<m.status.size();j++){
                String [] type = m.status.get(j).getClass().toString().split(" ");
                StringBuilder name = new StringBuilder();
                int q = type[1].length()-1;
                while(type[1].charAt(q) != '.'){
                    name.append(type[1].charAt(q));
                    q--;
                }
                condition = name.reverse().toString().toLowerCase(Locale.ROOT);
                if(condition.equals(s)){
                    display(m.matrix);
                }
            }
        }
    }
    void EigenVaV(Matrix m) {
        double a = m.matrix[0][0];
        double b = m.matrix[0][1];
        double c = m.matrix[1][0];
        double d = m.matrix[1][1];
        double a1 = Math.pow(a - d, 2) + 4 * b * c;
        double eigen1 = ((a + d) + Math.sqrt(a1)) / 2;
        double eigen2 = ((a + d) - Math.sqrt(a1)) / 2;
        System.out.println("ans = ");
        System.out.println("\t" + eigen1);
        System.out.println("\t" + eigen2);

//        for (double y = -1000; y <= 1000; y++) {
//            for (double x = -1000; x <= 1000; x++) {
//                if (((a-eigenvalue1)*x + b*y == 0) && (c*x + (d-eigenvalue1)*y == 0)) {
//                    System.out.println("Eigenvector1: (" + x + "," + y + ")");
//                }
//            }
//        }
//        for (double y = -10; y <= 10; y++) {
//            for (double x = -10; x <= 10; x++) {
//                if (((a-eigenvalue2)*x + b*y == 0) && (c*x + (d-eigenvalue2)*y == 0)) {
//                    System.out.println("Eigenvector2: (" + x + "," + y + ")");
//                }
//            }
//        }
//    }
    }
    Matrix Task3(Matrix m){
        String s = "";
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i<m.status.size();i++){
            for (int j = 0; i < m.status.size(); i++) {
                String [] type = m.status.get(j).getClass().toString().split(" ");
                StringBuilder name = new StringBuilder();
                int q = type[1].length()-1;
                while(type[1].charAt(q) != '.'){
                    name.append(type[1].charAt(q));
                    q--;
                }
                s = name.reverse().toString().toLowerCase(Locale.ROOT);
            }
            if(s.equals("nullmatrix") || s.equals("onesmatrix") || s.equals("symmetricmatrix")
                    || s.equals("skewsymmtricmatrix")||s.equals("identitymatrix")){
                System.out.println("Can't perform change for the matrix");
                return null;
            }
            else if(s.equals("diagonalmatrix")){
                System.out.println("Enter the position in the matrix: ");
                int R = sc.nextInt();
                int C = sc.nextInt();
                if(R != C){
                    System.out.println("Cannot perform any change in the matrix");
                    return null;
                }
                else{
                    System.out.println("Give the element: ");
                    float num = sc.nextFloat();
                    m.matrix[R][C] = num;
                }
            }
            else if(s.equals("scalarmatrix")){
                System.out.println("Enter the position in the matrix(note:- all the elements along the diagonal will change to the input): ");
                int R = sc.nextInt();
                int C = sc.nextInt();
                if(R != C){
                    System.out.println("Cannot perform any change in the matrix");
                }
                else{
                    System.out.println("Give the element: ");
                    float num = sc.nextFloat();
                    for(int j = 0;j<R;j++){
                        for(int k = 0;k<C;k++){
                            if(j == k){
                                m.matrix[j][k] = num;
                            }
                        }
                    }
                }
            }
            else if(s.equals("rowmatrix")){
                System.out.println("Enter the position in the matrix");
                int R = sc.nextInt();
                int C = sc.nextInt();
                if(R != 1){
                    System.out.println("Cannot perform any change in the matrix");
                    return null;
                }
                else{
                    System.out.println("Give the element: ");
                    float num = sc.nextFloat();
                    m.matrix[R][C] = num;
                }
            }
            else if(s.equals("columnmatrix")){
                System.out.println("Enter the position in the matrix");
                int R = sc.nextInt();
                int C = sc.nextInt();
                if(C != 1){
                    System.out.println("Cannot perform any change in the matrix");
                    return null;
                }
                else{
                    System.out.println("Give the element: ");
                    float num = sc.nextFloat();
                    m.matrix[R][C] = num;
                }
            }
            else if(s.equals("lowertriangularmatrix")){
                System.out.println("Enter the position in the matrix");
                int R = sc.nextInt();
                int C = sc.nextInt();
                if(C < R){
                    System.out.println("Cannot perform any change in the matrix");
                    return null;
                }
                else{
                    System.out.println("Give the element: ");
                    float num = sc.nextFloat();
                    m.matrix[R][C] = num;
                }
            }
            else if(s.equals("uppertriangularmatrix")){
                System.out.println("Enter the position in the matrix");
                int R = sc.nextInt();
                int C = sc.nextInt();
                if(C > R){
                    System.out.println("Cannot perform any change in the matrix");
                    return null;
                }
                else{
                    System.out.println("Give the element: ");
                    float num = sc.nextFloat();
                    m.matrix[R][C] = num;
                }
            }
            else if(s.equals("singletonmatrix")){
                System.out.println("Give the element: ");
                float num = sc.nextFloat();
                m.matrix[0][0] = num;
            }
            else{
                System.out.println("Enter the position in the matrix");
                int R = sc.nextInt();
                int C = sc.nextInt();
                System.out.println("Give the element: ");
                float num = sc.nextFloat();
                m.matrix[R][C] = num;
            }
        }
    return m;
    }
    Matrix Task2(String type){
        Scanner sc = new Scanner(System.in);
        Matrix m = new Matrix();
        switch(type){
            case "rectangularmatrix":{
                RectangularMatrix m1 = new RectangularMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m1.formN(r,c);
                m = m.checkO(m);
            }
            break;
            case "rowmatrix":{
                RowMatrix m2 = new RowMatrix();
                System.out.println("Enter the number of columns: ");
                int c = sc.nextInt();
                m.matrix = m2.formN(c,1);
                m = m.checkO(m);
            }
            break;
            case "columnmatrix":{
                ColumnMatrix m3 = new ColumnMatrix();
                System.out.println("Enter the number of rows: ");
                int r = sc.nextInt();
                m.matrix = m3.formN(1,r);
                m = m.checkO(m);
            }
            break;
            case "squarematrix":{
                SquareMatrix m4 =  new SquareMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                if(r == c) {
                    m.matrix = m4.formN(r, c);
                    m = m.checkO(m);
                }
                else {
                    System.out.println("wrong dimensions");
                    return null;
                }
            }
            break;
            case "symmetricmatrix":{
                SymmetricMatrix m5 = new SymmetricMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m5.formN(r, c);
                if(m.matrix == null){
                    System.out.println("Wrong Dimensions");
                    return null;
                }
                else{
                    m=m.checkO(m);
                }
            }
            break;
            case "skewsymmetricmatrix":{
                SkewSymmetricMatrix m6 = new SkewSymmetricMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m6.formN(r, c);
                if(m6.matrix != null) {
                    m = m.checkO(m);
                }
                else return null;
            }
            break;
            case "uppertriangularmatrix":{
                UpperTriangularMatrix m7 = new UpperTriangularMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m7.formN(r, c);
                if(m7.matrix != null) {
                    m = m.checkO(m);
                }
                else return null;
            }
            break;
            case "lowertriangularmatrix":{
                LowerTriangularMatrix m8 = new LowerTriangularMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m8.formN(r, c);
                if(m8.matrix != null) {
                    m = m.checkO(m);
                }
                else return null;
            }
            break;
            case "singularmatrix":{
                SingularMatrix m9 = new SingularMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m9.formN(r, c);
                if(m9.matrix != null) {
                    m = m.checkO(m);
                }
                else return null;
            }
            break;
            case "diagonalmatrix":{
                DiagonalMatrix m10 = new DiagonalMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m10.formN(r, c);
                if(m10.matrix != null) {
                    m = m.checkO(m);
                }
                else return null;
            }
            break;
            case "scalarmatrix":{
                ScalarMatrix m11 = new ScalarMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m11.formN(r, c);
                if(m11.matrix != null) {
                    m = m.checkO(m);
                }
                else return null;
            }
            break;
            case "identitymatrix":{
                IdentityMatrix m12 = new IdentityMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m12.formN(r, c);
                if(m12.matrix != null) {
                    m = m.checkO(m);
                }
                else return null;
            }
            break;
            case "singletonmatrix":{
                SingletonMatrix m13 = new SingletonMatrix();
                m.matrix = m13.formN(1,1);
                m = m.checkO(m);
            }
            break;
            case "onesmatrix":{
                OnesMatrix m14 = new OnesMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m14.formN(r,c);
                m = m.checkO(m);
            }
            break;
            case "nullmatrix":{
                NullMatrix m15 = new NullMatrix();
                System.out.println("Enter the number of rows and columns: ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                m.matrix = m15.formN(r,c);
                m = m.checkO(m);
            }
            break;
            default:
                System.out.println("Matrix type does not exist");
        }
        m.r = m.matrix.length;
        m.c = m.matrix[0].length;
        return m;
    }
}

public class AP_Assignment3 {
    protected HashMap<String, Matrix> matrix = new HashMap<>();
    public static void main(String[] args) throws IOException {
        AP_Assignment3 a = new AP_Assignment3();
        MatrixOperations mo = new MatrixOperations();
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("""
                    1. Take matrices as input and label them with appropriate matrix-types.
                    2. Create matrices of requested matrix-types and label them with appropriate matrix-types.
                    3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.
                    4. Display all the matrix-type labels of a requested matrix.
                    5. Perform addition, subtraction, multiplication & division.
                    6. Perform element-wise operations.
                    7. Transpose matrices.
                    8. Inverse matrices.
                    9. Compute means: row-wise mean, column-wise mean, mean of all the elements.
                    10. Compute determinants.
                    11. Use singleton matrices as scalars, if requested.
                    12. Compute A+AT
                    13. Compute Eigen vectors and values.
                    14. Solve sets of linear equations using matrices.
                    15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.""");
            int op = sc.nextInt();
            switch (op) {
                case 1: {
                    String inp = reader.readLine();
                    String name = "";
                    int i = 0;
                    while (inp.charAt(i) != '=') {
                        name = name + inp.charAt(i);
                        i++;
                    }
                    Matrix m = new Matrix();
                    m = m.setM(inp);
                    m = m.form();
                    m = m.checkO(m);
                    a.matrix.put(name, m);
                    System.out.println(name + "=");
                    mo.display(m.matrix);
                }
                break;
                case 2: {
                    System.out.println("Enter the type of Matrix(note:- write in the format(type Matrix): ");
                    String[] temp = reader.readLine().split(" ");
                    String type = temp[0] + temp[1];
                    type = type.toLowerCase(Locale.ROOT);
                    System.out.println("Enter the name for the matrix: ");
                    String name = reader.readLine();
                    Matrix m = mo.Task2(type);
                    if (m != null) {
                        a.matrix.put(name, m);
                        System.out.println(name + " =");
                        mo.display(m.matrix);
                    }
                }
                break;
                case 3: {
                    System.out.println("Enter the name of the matrix: ");
                    String name = reader.readLine();
                    if (mo.Task3((a.matrix.get(name))) != null) {
                        Matrix m = mo.Task3(a.matrix.get(name));
                        a.matrix.put(name, m);
                    }
                }
                break;
                case 4: {
                    System.out.println("Enter the name of the matrix:");
                    String inp = reader.readLine();
                    if (a.matrix.get(inp).status == null) {
                        System.out.println("No matrix of the given exists");
                    } else {
                        for (int i = 0; i < a.matrix.get(inp).status.size(); i++) {
                            String [] s = a.matrix.get(inp).status.get(i).getClass().toString().split(" ");
                            StringBuilder name = new StringBuilder();
                            int q = s[1].length()-1;
                            while(s[1].charAt(q) != '.'){
                                name.append(s[1].charAt(q));
                                q--;
                            }
                            System.out.println(name.reverse());
                        }
                    }
                }
                break;
                case 5: {
                    System.out.println("Choose the operation:(+,-,*,/) ");
                    String sign = reader.readLine();
                    switch (sign) {
                        case "+": {
                            System.out.println("Need to perform Addition. Choose the matrices:");
                            String[] name = reader.readLine().split(",");
                            mo.Addition(a.matrix.get(name[0]), a.matrix.get(name[1]));
                        }
                        break;
                        case "-": {
                            System.out.println("Need to perform Subtraction. Choose the matrices:");
                            String[] name = reader.readLine().split(",");
                            mo.Subtraction(a.matrix.get(name[0]), a.matrix.get(name[1]));
                        }
                        break;
                        case "*": {
                            System.out.println("Need to perform Multiplication. Choose the matrices:");
                            String[] name = reader.readLine().split(",");
                            mo.Multiplication(a.matrix.get(name[0]), a.matrix.get(name[1]));
                        }
                        break;
                        case "/": {
                            System.out.println("Need to perform Division. Choose the matrices:");
                            String[] name = reader.readLine().split(",");
                            mo.Multiplication(a.matrix.get(name[0]), a.matrix.get(name[1]));
                        }
                        break;
                    }
                }
                break;
                case 6: {
                    System.out.println("Choose the operation:(+,-,*,/) ");
                    String sign = reader.readLine();
                    switch (sign) {
                        case "+": {
                            System.out.println("Need to perform Element-wise Addition. Choose the matrices:");
                            String[] name = reader.readLine().split(",");
                            mo.Addition(a.matrix.get(name[0]), a.matrix.get(name[1]));
                        }
                        break;
                        case "-": {
                            System.out.println("Need to perform Element-wise Subtraction. Choose the matrices:");
                            String[] name = reader.readLine().split(",");
                            mo.Subtraction(a.matrix.get(name[0]), a.matrix.get(name[1]));
                        }
                        break;
                        case "*": {
                            System.out.println("Need to perform Element-wise Multiplication. Choose the matrices:");
                            String[] name = reader.readLine().split(",");
                            mo.EleMultiplication(a.matrix.get(name[0]), a.matrix.get(name[1]));
                        }
                        break;
                        case "/": {
                            System.out.println("Need to perform Element-wise Division. Choose the matrices:");
                            String[] name = reader.readLine().split(",");
                            mo.EleDivision(a.matrix.get(name[0]), a.matrix.get(name[1]));
                        }
                        break;
                    }
                }
                break;
                case 7: {
                    System.out.println("Need to transpose a matrix. Choose one matrix: ");
                    String name = reader.readLine();
                    a.matrix.put(name, mo.Transpose(a.matrix.get(name)));
                }
                break;
                case 8: {
                    System.out.println("Need to inverse a matrix. Choose one matrix");
                    String name = reader.readLine();
                    if (a.matrix.get(name).r == 0 && a.matrix.get(name).c == 0) {
                        System.out.println(0);
                    } else if (a.matrix.get(name).r == 1 && a.matrix.get(name).c == 1) {
                        System.out.println("Inverse does not exist");
                    } else if (a.matrix.get(name).r == a.matrix.get(name).c) {
                        mo.InverseMatrix(a.matrix.get(name));
                    } else {
                        System.out.println("Cannot compute Inverse");
                    }
                }
                break;
                case 9: {
                    System.out.println("""
                            Choose the type of mean:
                            1. Row-wise
                            2. Column-wise
                            3. Element-wise""");
                    int op2 = sc.nextInt();
                    switch (op2) {
                        case 1: {
                            System.out.println("Compute row-wise mean of a matrix. Choose one matrix");
                            String name = reader.readLine();
                            if (a.matrix.get(name).r == 0 && a.matrix.get(name).c == 0) {
                                System.out.println(0);
                            } else if (a.matrix.get(name).r == 1 && a.matrix.get(name).c == 1) {
                                System.out.println(a.matrix.get(name).matrix[0][0]);
                            } else {
                                mo.RowMean(a.matrix.get(name));
                            }
                        }
                        break;
                        case 2: {
                            System.out.println("Compute column-wise mean of a matrix. Choose one matrix");
                            String name = reader.readLine();
                            if (a.matrix.get(name).r == 0 && a.matrix.get(name).c == 0) {
                                System.out.println(0);
                            } else if (a.matrix.get(name).r == 1 && a.matrix.get(name).c == 1) {
                                System.out.println(a.matrix.get(name).matrix[0][0]);
                            } else {
                                mo.ColumnMean(a.matrix.get(name));
                            }
                        }
                        break;
                        case 3: {
                            System.out.println("Compute element-wise mean of a matrix. Choose one matrix");
                            String name = reader.readLine();
                            if (a.matrix.get(name).r == 0 && a.matrix.get(name).c == 0) {
                                System.out.println(0);
                            } else if (a.matrix.get(name).r == 1 && a.matrix.get(name).c == 1) {
                                System.out.println(a.matrix.get(name).matrix[0][0]);
                            } else {
                                mo.EleMean(a.matrix.get(name));
                            }
                        }
                    }
                }
                break;
                case 10: {
                    System.out.println("Compute determinant of a matrix. Choose one matrix. Note: The matrix must be square matrix");
                    String name = reader.readLine();
                    if (a.matrix.get(name).r == 0 && a.matrix.get(name).c == 0) {
                        System.out.println(0);
                    } else if (a.matrix.get(name).r == 1 && a.matrix.get(name).c == 1) {
                        System.out.println(a.matrix.get(name).matrix[0][0]);
                    } else if (a.matrix.get(name).r == a.matrix.get(name).c) {
                        System.out.println(mo.determinant(a.matrix.get(name).matrix, a.matrix.get(name).matrix.length));
                    } else {
                        System.out.println("Cannot compute determinant");
                    }
                }
                break;
                case 11: {
                    System.out.println("Use singleton matrix in matrix operations. Do you allow using singleton matrices as a scalar value?");
                    String inp = reader.readLine();
                    if (inp.equals("yes")) {
                        System.out.println("Then choose a matrix");
                        String name1 = reader.readLine();
                        System.out.println("Choose a singleton matrix now.");
                        String name2 = reader.readLine();
                        if (a.matrix.get(name2).c == 1 && a.matrix.get(name2).r == 1) {
                            System.out.println("Choose Operation:(/,*)");
                            String sign = reader.readLine();
                            mo.Task11(a.matrix.get(name2), a.matrix.get(name1), sign);
                        } else {
                            System.out.println("The chosen matrix is not singleton");
                        }
                    }
                }
                break;
                case 12: {
                    System.out.println("Compute A+A' of a matrix. Choose one matrix. Note that it must be a square matrix.");
                    String name = reader.readLine();
                    if (a.matrix.get(name).r == a.matrix.get(name).c && a.matrix.get(name).c != 1 && a.matrix.get(name).r != 1) {
                        mo.AddTranspose(a.matrix.get(name));
                    } else {
                        System.out.println("the chosen matrix is not a square matrix");
                    }
                }
                break;
                case 13: {
                    System.out.println("Compute eigen values of a matrix.");
                    System.out.println("Choose a square matrix");
                    String name = reader.readLine();
                    if (a.matrix.get(name).r == a.matrix.get(name).c && a.matrix.get(name).c != 1 && a.matrix.get(name).r != 1) {
                        mo.EigenVaV(a.matrix.get(name));
                    } else {
                        System.out.println("the chosen matrix is not a square matrix");
                    }
                }
                break;
                case 14: {
                    System.out.println("Solve a set of linear equation.");
                    System.out.println("Choose a square matrix");
                    String name1 = reader.readLine();
                    System.out.println("Choose a column matrix. Note: this should have same number of rows as the one you entered just now");
                    String name2 = reader.readLine();
                    if (a.matrix.get(name1).r == a.matrix.get(name1).c && a.matrix.get(name1).r == a.matrix.get(name2).r && a.matrix.get(name2).c == 1) {
                        mo.SolveMatrix(a.matrix.get(name1), a.matrix.get(name2));
                    } else {
                        System.out.println("Input given are of not correct dimension");
                    }
                }
                break;
                case 15: {
                    System.out.println("Enter type of matrices you want to retrieve: ");
                    String type = reader.readLine();
                    ArrayList<Matrix> m = new ArrayList<>();
                    a.matrix.forEach((k, v) ->
                            m.add(v)
                    );
                    mo.Task15(m, type);
                }
                break;
                default:
                    System.exit(0);
            }
        }
    }
}
