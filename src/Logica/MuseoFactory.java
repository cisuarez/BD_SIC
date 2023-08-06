public class MuseoFactory extends InteresCulturalFactory {
    @Override
    public InteresCultural crearInteresCultural() {
        return new Museo();
    }
}
