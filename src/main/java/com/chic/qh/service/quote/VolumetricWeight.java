package com.chic.qh.service.quote;

/**
 * Volumetric weight refers to the overall size of a parcel and is measured in volumetric kilograms.
 * Volumetric weight can be calculated by multiplying the length, width and height of a parcel (in cm)
 * and dividing that figure by 5000 (some carriers use a divisor of 4000).
 */
public class VolumetricWeight {

    //记抛比
    private Integer rate;

    private Integer length;
    private Integer width;
    private Integer height;

    //精确到克(g)
    private Integer volWeight;
    /**
     * params should be converted to cm
     * @param length
     * @param width
     * @param height
     *
     * 记抛重精确到g，所以对于 5000 的记抛比，rate设置成 5
     * @param rate
     */
    public VolumetricWeight(Integer length, Integer width, Integer height, Integer rate) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.rate = rate;
    }

    public Integer getValue() {
        if(this.volWeight == null){
            Integer vol = this.height * this.length * this.width;
            Integer dividedVol = vol / this.rate;
            this.volWeight =  (dividedVol * this.rate == vol) ? dividedVol : (dividedVol + 1);
        }
        return this.volWeight;
    }
}
