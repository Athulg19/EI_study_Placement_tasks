package Excercise_01.Structural_design_pattern.Adapter_Pattern;

interface LightningPhone {
    void recharge();
    void useLightning();
}

interface MicroUsbPhone {
    void recharge();
    void useMicroUsb();
}

class Iphone implements LightningPhone {
    private boolean connector;

    @Override
    public void useLightning() {
        connector = true;
        System.out.println("Lightning connected");
    }

    @Override
    public void recharge() {
        if (connector) {
            System.out.println("Recharge started");
            System.out.println("Recharge finished");
        } else {
            System.out.println("Connect Lightning first");
        }
    }
}

class Android implements MicroUsbPhone {
    private boolean connector;

    @Override
    public void useMicroUsb() {
        connector = true;
        System.out.println("MicroUsb connected");
    }

    @Override
    public void recharge() {
        if (connector) {
            System.out.println("Recharge started");
            System.out.println("Recharge finished");
        } else {
            System.out.println("Connect MicroUsb first");
        }
    }
}

class LightningToMicroUsbAdapter implements MicroUsbPhone {
    private LightningPhone lightningPhone;

    public LightningToMicroUsbAdapter(LightningPhone lightningPhone) {
        this.lightningPhone = lightningPhone;
    }

    @Override
    public void useMicroUsb() {
        System.out.println("MicroUsb connected to Adapter");
        lightningPhone.useLightning();
    }

    @Override
    public void recharge() {
        lightningPhone.recharge();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Android android = new Android();
        Iphone iphone = new Iphone();

        System.out.println("Recharging android with MicroUsb");
        android.useMicroUsb();
        android.recharge();

        System.out.println("Recharging iPhone with Lightning");
        iphone.useLightning();
        iphone.recharge();

        System.out.println("Recharging iPhone with MicroUsb using adapter");
        LightningToMicroUsbAdapter adapter = new LightningToMicroUsbAdapter(iphone);
        adapter.useMicroUsb();
        adapter.recharge();
    }
}
