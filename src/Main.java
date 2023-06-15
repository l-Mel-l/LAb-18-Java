enum RazmOd {
    XXS(32),
    XS(34),
    S(36),
    M(38),
    L(40);

    private final int euroSize;

    RazmOd(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription() {
        if (this == XXS) {
            return "Детский размер";
        } else {
            return "Взрослый размер";
        }
    }
}

interface MaleClothes {
    void OdMan();
}

interface FemaleClothes {
    void OdWoman();
}

abstract class Clothes {
    private RazmOd size;
    private double cost;
    private String color;

    Clothes(RazmOd size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    public RazmOd getSize() {
        return size;
    }

    public double getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }
}
class TShirt extends Clothes implements MaleClothes, FemaleClothes {
    TShirt(RazmOd size, double cost, String color) {

        super(size, cost, color);
    }
    @Override
    public void OdMan() {
        System.out.println("Мужчина надел футболку с размером " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost() + ".");
    }

    @Override
    public void OdWoman() {
        System.out.println("Женщина надела футболку с размером " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost());
    }
}

class Pants extends Clothes implements MaleClothes, FemaleClothes {
    Pants(RazmOd size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void OdMan() {
        System.out.println("Мужчина надел штаны с размером " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost());
    }

    @Override
    public void OdWoman() {
        System.out.println("Женщина надела штаны с размером " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost());
    }
}

class Skirt extends Clothes implements FemaleClothes {
    Skirt(RazmOd size, double cost, String color) {
        super(size, cost, color);

    }

    @Override
    public void OdWoman() {
        System.out.println("Женщина надела юбку с размером " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost());
    }
}

class Tie extends Clothes implements MaleClothes {
    Tie(RazmOd size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void OdMan() {
        System.out.println("Мужчина надел галстук с размером " + getSize().name() +
                ", цвета " + getColor() + ", стоимостью " + getCost());
    }
}

class Atelier {
    public void OdWoman(Clothes[] clothes) {
        System.out.println("Женская одежда:");
        for (Clothes c : clothes) {
            if (c instanceof FemaleClothes) {
                ((FemaleClothes) c).OdWoman();
            }
        }
    }

    public void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда:");
        for (Clothes c : clothes) {
            if (c instanceof MaleClothes) {
                ((MaleClothes) c).OdMan();
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(RazmOd.XS, 550, "Лягушка в обмороке"),
                new Pants(RazmOd.L, 800, "Бобровый"),
                new Skirt(RazmOd.M, 600, "Вердепешовый"),
                new Tie(RazmOd.XXS, 300, "Влюблённой жабы")
        };

        Atelier atelier = new Atelier();
        atelier.OdWoman(clothes);
        atelier.dressMan(clothes);
    }
}