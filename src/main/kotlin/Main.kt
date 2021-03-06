import org.jetbrains.numkt.core.*
import org.jetbrains.numkt.math.*
import org.jetbrains.numkt.*
import org.jetbrains.numkt.linalg.Linalg.Companion.inv
import org.jetbrains.numkt.linalg.Linalg.Companion.matrixPower


// Сапожников Ярослав, ПИ19-2, Вариант 42

// Матрица создается при помощи array(arrayOf(
// .dot - перемножение матриц
// matrixPower() - возведение матрицы в степень
// kotlin: for (i in 1 until 100) или for (i in 1..99), python: for i in range(1, 100)

// 6, 7, 8 задания не удалось выполнить, потому что не смог разобраться с многомерными массивами в языке Котлин
// черновики оставил, они закомментированы
// если возникнут проблемы с запуском кода, могу ответить на все вопросы
// на все вопросы по самому коду также могу ответить на почте
// логику полностью взял из питон файла, почти ее не менял


@ExperimentalNumkt
fun main() {

    val mx = array(arrayOf(
        0.0, 0.04, 0.12, 0.13, 0.22, 0.0, 0.11, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.57, 0.0, 0.0, 0.37, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.39, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.47, 0.0, 0.0, 0.0, 0.0,
        0.09, 0.22, 0.26, 0.0, 0.14, 0.0, 0.0, 0.0, 0.02, 0.25, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.33, 0.17, 0.16, 0.07, 0.0, 0.0, 0.0, 0.0,
        0.37, 0.05, 0.0, 0.0, 0.0, 0.0, 0.21, 0.0, 0.06, 0.0, 0.0, 0.29, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.15, 0.0, 0.0, 0.0, 0.74, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.9, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.36, 0.0, 0.0, 0.27, 0.0, 0.0, 0.0, 0.0, 0.13, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.27, 0.0, 0.0, 0.0, 0.27, 0.0, 0.0, 0.0, 0.15, 0.0, 0.0, 0.1,
        0.0, 0.0, 0.0, 0.27, 0.0, 0.22, 0.0, 0.0, 0.0, 0.0, 0.0, 0.18, 0.0, 0.0, 0.27, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.15, 0.0, 0.0, 0.0, 0.2, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.74, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.39, 0.26, 0.0, 0.0, 0.01, 0.0, 0.0, 0.29, 0.0,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.41, 0.0, 0.0, 0.19, 0.0, 0.0, 0.0, 0.21,
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.29, 0.0, 0.0, 0.29, 0.0
    )).reshape(16, 16)

    mx.toList2d()

    for (i in 0..15) {
        var s = 0.0;
        for (j in 0..15) {
            s += getItem(mx, i, j)
        }
        mx[i][i] = 1 - s
    }

    println(mx)

//    [[0.38 0.04 0.12 0.13 0.22 0.   0.11 0.   0.   0.   0.   0.   0.   0.
//    0.   0.  ]
//    [0.57 0.06 0.   0.37 0.   0.   0.   0.   0.   0.   0.   0.   0.   0.
//    0.   0.  ]
//    [0.39 0.   0.14 0.   0.   0.   0.   0.   0.   0.   0.   0.47 0.   0.
//    0.   0.  ]
//    [0.09 0.22 0.26 0.02 0.14 0.   0.   0.   0.02 0.25 0.   0.   0.   0.
//    0.   0.  ]
//    [0.   0.   0.   0.   0.27 0.   0.   0.   0.33 0.17 0.16 0.07 0.   0.
//    0.   0.  ]
//    [0.37 0.05 0.   0.   0.   0.02 0.21 0.   0.06 0.   0.   0.29 0.   0.
//    0.   0.  ]
//    [0.   0.   0.   0.   0.   0.15 0.11 0.   0.   0.74 0.   0.   0.   0.
//    0.   0.  ]
//    [0.   0.   0.   0.   0.   0.   0.9  0.1  0.   0.   0.   0.   0.   0.
//    0.   0.  ]
//    [0.   0.   0.   0.   0.   0.   0.36 0.   0.24 0.27 0.   0.   0.   0.
//    0.13 0.  ]
//    [0.   0.   0.   0.   0.27 0.   0.   0.   0.27 0.21 0.   0.   0.15 0.
//    0.   0.1 ]
//    [0.   0.   0.   0.27 0.   0.22 0.   0.   0.   0.   0.06 0.18 0.   0.
//    0.27 0.  ]
//    [0.   0.   0.   0.   0.   0.   0.   0.   0.   0.   0.15 0.65 0.   0.
//    0.2  0.  ]
//    [0.   0.   0.   0.   0.   0.   0.   0.   0.   0.74 0.   0.   0.26 0.
//    0.   0.  ]
//    [0.   0.   0.   0.   0.   0.   0.   0.39 0.26 0.   0.   0.01 0.   0.05
//    0.29 0.  ]
//    [0.   0.   0.   0.   0.   0.   0.   0.   0.41 0.   0.   0.19 0.   0.
//    0.19 0.21]
//    [0.   0.   0.   0.   0.   0.   0.   0.   0.   0.   0.   0.29 0.   0.
//    0.29 0.42]]


    //1) вероятность того, что за 6 шагов система перейдет из состояния 9 в состояние 11;

    val mx6 = matrixPower(mx, 6)
    println("1) " + mx6[8][10])

    // Ответ: 0.035067708084000004


    //2) вероятности состояний системы спустя 10 шагов, если в начальный момент вероятность состояний были следующими
    // A=(0,08;0,02;0,02;0,12;0,07;0,1;0,03;0,02;0,07;0,11;0,09;0,08;0,04;0,11;0,04;0);

    val a0 = array(arrayOf(0.08, 0.02, 0.02, 0.12, 0.07, 0.1, 0.03, 0.02, 0.07, 0.11, 0.09, 0.08, 0.04, 0.11, 0.04, 0.0))
    a0.toList()
    var mxa = matrixPower(mx, 10)
    mxa = a0.dot(mxa)
    println("2) " + mxa)

    // Ответ: [2.78424148e-02 6.55821202e-03 9.56184084e-03 1.78265374e-02
    // 7.87519674e-02 2.03659988e-02 7.19764900e-02 8.77162109e-11
    // 1.57263758e-01 1.78477219e-01 4.16942142e-02 1.78022754e-01
    // 3.63480712e-02 1.07421875e-14 1.06692963e-01 6.86175585e-02]


    //3) вероятность первого перехода за 8 шагов из состояния 16 в состояние 10

    var firstTrans = firstTrans(mx, 8)
    println("3) " + firstTrans[15][9])

    // Ответ: 0.017896146677537996


    //4) вероятность перехода из состояния 7 в состояние 4 не позднее чем за 7 шагов

    var mx4 = mx[6][3]
    var transMx = mx
    for (i in 1..7) {
        transMx = mx.dot(transMx)
        mx4 = transMx[6][3] + mx4
    }

    println("4) " + mx4)

    // Ответ: 0.0845461079424837


    //5) среднее количество шагов для перехода из состояния 8 в состояние 2;

    transMx = mx
    var mx5 = transMx[7][1]

    for (i in 2 until 1000) {
        transMx = multiply(mx, transMx)
        mx5 = i * transMx[7][1] + mx5
    }

    println("5) " + mx5)

    // Ответ: 18.64808687840684


    //println(firstReturn(mx, 6))

    //9) установившиеся вероятности.

    println("9) " + findConstant(mx))

    val lu = 29.0  // интенсивность поступления
    val m = 5  // количество каналов обслуживания
    val mu = 8.0  // интенсивность обслуживания
    val n = 15  // максимальный размер очереди

    // Ответ: [[0.02611029]
    // [0.00628557]
    // [0.00892493]
    // [0.01747001]
    // [0.07623329]
    // [0.0204124 ]
    // [0.07143177]
    // [0.        ]
    // [0.15670984]
    // [0.17577864]
    // [0.04222447]
    // [0.18329119]
    // [0.03563081]
    // [0.        ]
    // [0.109532  ]
    // [0.0699648 ]]


    // заполнение матрицы интенсивностей

    var intesives: KtNDArray<Double> = zeros(m + n + 1, m + n + 1)

    for (i in 0 until n + m) {
        intesives[i][i + 1] = lu
    }

    for (i in 1 until n + m + 1) {
        if (i < m) {
            intesives[i][i - 1] = i * mu
        } else {
            intesives[i][i - 1] = m * mu
        }
    }

    println(intesives)

    //[[ 0. 29.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 8.  0. 29.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0. 16.  0. 29.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0. 24.  0. 29.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0. 32.  0. 29.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0. 40.  0. 29.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0. 40.  0. 29.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0. 40.  0. 29.  0.  0.  0.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0. 40.  0. 29.  0.  0.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0. 40.  0. 29.  0.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0. 40.  0. 29.  0.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0.  0. 40.  0. 29.  0.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0. 40.  0. 29.  0.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0. 40.  0. 29.  0.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0. 40.  0. 29.  0.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0. 40.  0. 29.  0.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0. 40.  0. 29.
    //   0.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0. 40.  0.
    //  29.  0.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0. 40.
    //   0. 29.  0.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.
    //  40.  0. 29.]
    // [ 0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.  0.
    //   0. 40.  0.]]


    // a) Составьте граф марковского процесса, запишите систему уравнений Колмогорова и найдите установившиеся вероятности состояний.

    val prob = probabilities(intesives);
    println("a) " + prob)

    // Ответ: [[0.02213028]
    // [0.08022227]
    // [0.14540286]
    // [0.17569512]
    // [0.1592237 ]
    // [0.11543718]
    // [0.08369196]
    // [0.06067667]
    // [0.04399059]
    // [0.03189317]
    // [0.02312255]
    // [0.01676385]
    // [0.01215379]
    // [0.0088115 ]
    // [0.00638834]
    // [0.00463154]
    // [0.00335787]
    // [0.00243446]
    // [0.00176498]
    // [0.00127961]
    // [0.00092772]]


    // b) Найдите вероятность отказа в обслуживании.

    val b = prob[m+n]
    println("b) " + b)

    // Ответ: [0.00092772]


    // c) Найдите относительную и абсолютную интенсивность обслуживания.

    val c = 1 - b
    println("c) " + c)
    println("c2) " + c * lu)

    // Ответ: [0.99907228]
    // Ответ: [28.97309619]


    // d) Найдите среднюю длину в очереди.

    var length = 0.0
    for (i in 1..n){
        length += i * prob[m + i].toList()[0]
    }
    println("d) " + length)

    // Ответ: 1.061089682740443


    // e) Найдите среднее время в очереди.

    var queue = 0.0
    for (i in 1..m){
        queue += (i + 1) / (m * mu) * prob[m + i].toList()[0]
    }
    println("e)" + queue)

    // Ответ: 0.020589436223263362


    // f) Найдите среднее число занятых каналов.

    for (i in m+1..m+n){
        queue += m * prob[i].toList()[0]
    }
    println("f) " + queue)

    // Ответ: 1.5300323974525436


    // g) Найдите вероятность того, что поступающая заявка не будет ждать в очереди.

    var noWait = 0.0
    for (i in 0 until m) {
        noWait += prob[i].toList()[0]
    }
    println("g) " + noWait)

    // Ответ: 0.5826742240753953


    // h) Найти среднее время простоя системы массового обслуживания.

    val downtime = 1 / lu
    println("h) " +  downtime)

    // Ответ: 0.034482758620689655


}


@ExperimentalNumkt
fun getItem (matrix: KtNDArray<Double>, i: Int, j: Int): Double {

    return matrix.item(i * 16 + j)

}


@ExperimentalNumkt
fun power (mx: KtNDArray<Double>, power: Int): KtNDArray<Double> {

    var mxNew = mx
    for (i in 1..power) {
        mxNew = mxNew.dot(mx)
    }

    return mxNew
}


@ExperimentalNumkt
fun firstTrans (mx: KtNDArray<Double>, k: Int): KtNDArray<Double> {

    var result = mx

    for (i in 1 until k) {
        result = multiply(result, mx)
    }
    return result
}


@ExperimentalNumkt
fun multiply (mx1: KtNDArray<Double>, mx2: KtNDArray<Double>): KtNDArray<Double> {

    val result:KtNDArray<Double> = zeros(mx1.shape[0], mx2.shape[1])

    for (i in 1 until mx1.shape[0]){
        for (j in 1 until mx2.shape[1]) {
            for (k in 1 until mx2.shape[0]) {
                if (k != j) {
                    result[i][j] = getItem(mx1, i, k) * getItem(mx2, k, j) + getItem(result, i, j)

                }
            }
        }
    }

    return result
}


//@ExperimentalNumkt
//fun firstReturn (mx: KtNDArray<Double>, k: Int): KtNDArray<Double> {
//    if (k <= 1) {
//        return (mx)
//    } else {
//        val pZeros: KtNDArray<Double> = zeros(mx.shape[0], mx.shape[1], k)
//        for (i in 1..k) {
//            val mp = matrixPower(mx, i)
//            for (j in 1 until pZeros.shape[0]) {
//                for (m in 1 until pZeros.shape[1]) {
//                    pZeros[j][m][i] = mp[j][m]
//                }
//            }
//        }
//        var f = pZeros
//        for (i in 2..k) {
//            for (j in 1 until k) {
//                for (n in 1 until pZeros.shape[0]) {
//                    for (m in 1 until pZeros.shape[1]) {
//                        f[m][n][i] = f[m][n][i] - f[m][n][j][i - j]
//                    }
//                }
//            }
//        }
//        var result:KtNDArray<Double> = zeros(f.shape[2])
//
//    }
//}


@ExperimentalNumkt
fun findConstant (mx: KtNDArray<Double>): KtNDArray<Double> {
    val mxT = mx.transpose();

    for (i in 0 until mx.shape[0]){
        mxT[i][i] = mx[i][i] - 1
    }
    mxT[mx.shape[0] - 1] = 1.0
    val mxZeros: KtNDArray<Double> = zeros(mx.shape[0], 1)
    mxZeros[mx.shape[0] - 1] = 1.0
    val result: KtNDArray<Double> = matrixPower(mxT, -1).dot(mxZeros)
    return result

}


@ExperimentalNumkt
fun probabilities(intesives: KtNDArray<Double>): KtNDArray<Double> {
    val m = 5;
    val n = 15;
    val mxZeros: KtNDArray<Double> = zeros(m+n+1, m+n+1)
    for (i in 0 until m+n){
        mxZeros[i][i] = intesives[i].toList().sum()
    }
    val mxTransponded = intesives.transpose()
    val mx = mxTransponded - mxZeros
    val mxZeros_2: KtNDArray<Double> = zeros(m+n+1, 1)
    mxZeros_2[m+n][0] = 1.0
    val mx2 = mx
    for (i in 0 until mx2.shape[0]){
        mx2[-1][i] = 1.0
    }
    val mxObr: KtNDArray<Double> = inv(mx2);
    val result = mxObr.dot(mxZeros_2);
    return result
}


//fun probabilities (intensives: KtNDArray<Double>): KtNDArray<Double> {
//
//    val m = 5
//    val n = 15
//
//    var d: KtNDArray<Double> = zeros(m + n + 1, m + n + 1)
//
//    for (i in 1 until m + n + 1) {
//        d[i][i] = intensives[i].toList().sum()
//    }
//
//    val mTransponded = intensives.transpose()
//    val mMatrix = mTransponded - d
//
//    val mxZeros_2: KtNDArray<Double> = zeros(m+n+1, 1)
//    d[m+n][0] = 1.0
//    val mMatrix2 = mMatrix
//    for (i in 1 until mMatrix.shape[0]){
//        mMatrix2[-1][i] = 1.0
//    }
//    val M_obr: KtNDArray<Double> = inv(mMatrix);
//    val result = M_obr.dot(mxZeros_2);
//    return result
//
//}
