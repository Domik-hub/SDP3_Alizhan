import device.Device;
import device.TvDevice;
import device.RadioDevice;
import device.ProjectorDevice;
import remote.Remote;
import remote.BasicRemote;
import remote.QuietRemote;

public class Main {
    public static void main(String[] args) {
        int passed = 0;

        Remote a1i1 = new BasicRemote("REMOTE-1", new TvDevice());
        String res1 = a1i1.execute();
        String exp1 = "TV [power=ON, volume=30]";
        if (res1.equals(exp1)) {
            System.out.println("T1 PASS | BasicRemote + TvDevice | result=" + res1);
            passed++;
        } else {
            System.out.println("T1 FAIL | expected=" + exp1 + " | actual=" + res1);
        }

        Remote a1i2 = new BasicRemote("REMOTE-2", new RadioDevice());
        String res2 = a1i2.execute();
        String exp2 = "Radio [power=ON, volume=30]";
        if (res2.equals(exp2)) {
            System.out.println("T2 PASS | BasicRemote + RadioDevice | result=" + res2);
            passed++;
        } else {
            System.out.println("T2 FAIL | expected=" + exp2 + " | actual=" + res2);
        }

        Remote a2i1 = new QuietRemote("REMOTE-3", new TvDevice());
        String res3 = a2i1.execute();
        String exp3 = "TV [power=ON, volume=5]";
        if (res3.equals(exp3)) {
            System.out.println("T3 PASS | QuietRemote + TvDevice | result=" + res3);
            passed++;
        } else {
            System.out.println("T3 FAIL | expected=" + exp3 + " | actual=" + res3);
        }

        Remote a2i2 = new QuietRemote("REMOTE-4", new RadioDevice());
        String res4 = a2i2.execute();
        String exp4 = "Radio [power=ON, volume=5]";
        if (res4.equals(exp4)) {
            System.out.println("T4 PASS | QuietRemote + RadioDevice | result=" + res4);
            passed++;
        } else {
            System.out.println("T4 FAIL | expected=" + exp4 + " | actual=" + res4);
        }

        Remote t5Remote = new BasicRemote("REMOTE-T5", new TvDevice());
        Remote refBefore = t5Remote;
        String idBefore = t5Remote.getId();
        int volBefore = t5Remote.getVolumePreset();
        String beforeRes = t5Remote.execute();

        t5Remote.setImplementation(new RadioDevice());
        Remote refAfter = t5Remote;
        String idAfter = t5Remote.getId();
        int volAfter = t5Remote.getVolumePreset();
        String afterRes = t5Remote.execute();

        boolean sameObject = (refBefore == refAfter);
        boolean stateUnchanged = idBefore.equals(idAfter) && (volBefore == volAfter);
        boolean resultsCorrect = beforeRes.equals(exp1) && afterRes.equals(exp2);

        if (sameObject && stateUnchanged && resultsCorrect) {
            System.out.println("T5 PASS sameObject=true | stateUnchanged=true before=" + beforeRes + " | after=" + afterRes);
            passed++;
        } else {
            System.out.println("T5 FAIL | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
        }

        Remote a1i3 = new BasicRemote("REMOTE-5", new ProjectorDevice());
        String res6 = a1i3.execute();
        String exp6 = "Projector [power=ON, volume=30]";
        if (res6.equals(exp6)) {
            System.out.println("T6 PASS | BasicRemote + ProjectorDevice | result=" + res6);
            passed++;
        } else {
            System.out.println("T6 FAIL | expected=" + exp6 + " | actual=" + res6);
        }

        Remote a2i3 = new QuietRemote("REMOTE-6", new ProjectorDevice());
        String res7 = a2i3.execute();
        String exp7 = "Projector [power=ON, volume=5]";
        if (res7.equals(exp7)) {
            System.out.println("T7 PASS | QuietRemote + ProjectorDevice | result=" + res7);
            passed++;
        } else {
            System.out.println("T7 FAIL | expected=" + exp7 + " | actual=" + res7);
        }

        System.out.println("SUMMARY: " + passed + "/7 PASS");
    }
}