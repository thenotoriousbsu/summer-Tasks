package task;

import entity.Auto;

import java.util.List;

public class Task {
    public static int task(List<Auto> autos) {
        int count = 0;
        for (int i = 0; i < autos.size(); i++) {
            for (int j = i + 1; j < autos.size(); j++) {
                if (autos.get(i).getCurrentPosition() != autos.get(j).getCurrentPosition() && autos.get(j).getVelocity() != autos.get(i).getVelocity()) {
                    double intersectionTime = (double) (autos.get(i).getCurrentPosition() - autos.get(j).getCurrentPosition()) / (double) (autos.get(j).getVelocity() - autos.get(i).getVelocity());
                    if (intersectionTime < Math.min(autos.get(i).getTime(), autos.get(j).getTime()) && intersectionTime > 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
