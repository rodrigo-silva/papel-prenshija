package lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data;

import lahija.papelprenshija.model.template.components.BackgroundTemplate;
import lahija.papelprenshija.model.template.components.TextSection;

/**
 * Interface for data transfer object.
 *
 * @author rsilva
 *
 */
public interface INewsPaperTemplateData {

   BackgroundTemplate getBackgroundTemplate();

   TextSection getTitleSection();

   TextSection getSubtitleSection();

   TextSection getImageCaption();

}