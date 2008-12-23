/*
This file is part of OFC4J.

OFC4J is free software: you can redistribute it and/or modify
it under the terms of the Lesser GNU General Public License as
published by the Free Software Foundation, either version 3 of
the License, or (at your option) any later version.

OFC4J is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

See <http://www.gnu.org/licenses/lgpl-3.0.txt>.
*/

package ofc4j.model.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import ofc4j.model.metadata.Alias;
import ofc4j.model.metadata.Converter;
import ofc4j.util.PieChartSliceConverter;

public class PieChart extends Element {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8853434988212173862L;
	@Alias("start-angle") private Integer startAngle;
    private Collection<String> colours;
    private Boolean animate;
    private Integer border;
    @Alias("no-labels") private Boolean noLabels;
    
    public PieChart() {
        super("pie");
    }
    
    public PieChart setAnimate(boolean animate) {
        this.animate = animate;
        return this;
    }
    
    public Boolean getAnimate() {
        return animate;
    }

    public Integer getStartAngle() {
        return startAngle;
    }

    public PieChart setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
        return this;
    }

    public Collection<String> getColours() {
        return colours;
    }

    public PieChart setColours(Collection<String> colours) {
        checkColours();
        this.colours = colours;
        return this;
    }
    
    public PieChart setColours(String... colours) {
        checkColours();
        this.colours.clear();
        this.colours.addAll(Arrays.asList(colours));
        return this;
    }
    
    public PieChart setColours(List<String> colours) {
        checkColours();
        this.colours.clear();
        this.colours.addAll(colours);
        return this;
    }
    
    public Integer getBorder() {
        return border;
    }
    
    public PieChart setBorder(Integer border) {
        this.border = border;
        return this;
    }

    public PieChart addValues(Number... values) {
        getValues().addAll(Arrays.asList(values));
        return this;
    }
    
    public PieChart addValues(List<Number> values) {
        getValues().addAll(values);
        return this;
    }
    
    public PieChart addSlice(Number value, String text) {
        return addSlices(new Slice(value, text));
    }
    
    public PieChart addSlices(Slice... s) {
        getValues().addAll(Arrays.asList(s));
        return this;
    }
    
    public PieChart addSlices(List<Slice> values) {
        getValues().addAll(values);
        return this;
    }
    
    @Converter(PieChartSliceConverter.class)
    public static class Slice implements Serializable{
        /**
		 * 
		 */
		private static final long serialVersionUID = 6961394996186973937L;
		private final String label;
        private final Number value;
        
        public Slice(Number value, String label) {
            this.label = label;
            this.value = value;
        }
        
        public Number getValue() {
            return value;
        }
        
        public String getLabel() {
            return label;
        }
        /**
         * Method getText() is depreceaded but kept for backwards compatibility with OFCJ
         * @return
         */
        public String getText() {
      	  return label;
        }
    }
    
    private synchronized void checkColours() {
        if (colours == null) colours = new ArrayList<String>();
    }

	
	public Boolean getNoLabels() {
		return noLabels;
	}

	
	public void setNoLabels(Boolean noLabels) {
		this.noLabels = noLabels;
	}
}