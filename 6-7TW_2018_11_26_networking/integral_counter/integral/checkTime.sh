for THREAD in 1 2 3 4 6 8 16 32
do
    START=$(date +%s)
    for i in {1..100}
    do

    java main.java.com.codecool.App 0 1000 0.01 $THREAD

    done

    END1=$(date +%s)
    DIFF=$(($END1-$START))
    echo thread $THREAD
    echo $DIFF

done


