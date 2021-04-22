class testValid{

	float sqrt(float square, float guess)
	{
        float nextGuess;
        nextGuess = 0.5 * (guess + square/guess);
        if (nextGuess - guess > -0.00001 && nextGuess - guess < 0.00001)
            return nextGuess;
        return sqrt(square, nextGuess);
	}

	float getDistance(float vecA[], float vecB[], int size)
    {
        int i = 0;
        float sum = 0;
        while (i < size)
        {
            sum = sum + (vecA[i] - vecB[i]) * (vecA[i] - vecB[i]);
            i++;
        }
        return sqrt(sum, 2);
    }

    void main()
    {
        float a[10];
        float b[10];
        final int maxSize = 10;
        int thisSize;
        bool validInput;
        int i;
        print("Input the size of your vectors: (max:" + maxSize + ")");
        printline();
        validInput = false;


    }

}