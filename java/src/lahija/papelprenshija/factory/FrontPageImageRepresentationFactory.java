package lahija.papelprenshija.factory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.imageio.ImageIO;

import lahija.papelprenshija.model.FrontPage;
import lahija.papelprenshija.model.exception.SystemException;
import lahija.papelprenshija.model.params.FrontPageInstanceParams;
import lahija.papelprenshija.model.template.INewspaperTemplate;
import lahija.papelprenshija.model.template.components.BackgroundTemplate;
import lahija.papelprenshija.model.template.components.TextSection;
import lahija.papelprenshija.model.template.components.TextSectionFont;
import lahija.papelprenshija.model.template.components.abstractions.TwoDimensionsValues;

/**
 * Front page image representation factory for a giving Newspaper template and params.
 *
 * @author rsilva
 *
 */
public class FrontPageImageRepresentationFactory {

   /** news paper template to create front pages from */
   private final INewspaperTemplate template;

   /** Convenient/handy instance variable. Is the same as it comes inside {@link #template} */
   private final BackgroundTemplate backgroundTemplate;

   /** Front Page Instance parameters*/
   private final FrontPageInstanceParams params;

   /** awt java object calculated when create a front page. It is needed to do all the awt magic stuff */
   private Graphics2D frontPageGraphics;

   /**
    *
    * @param frontPage to build from
    */
   public FrontPageImageRepresentationFactory(final FrontPage frontPage) {
      this.params = frontPage.getInstanceParams();
      this.template = frontPage.getNewspaperTemplate();
      this.backgroundTemplate = this.template.getBackgroundTemplate();
   }

   /**
    *
    * @return
    * @throws IOException
    */
   public BufferedImage createFrontPageImageRepresentation() {
      final BufferedImage frontPageImageRepresentation = this.getFrontPageImageRepresentation();
      this.createGraphics(frontPageImageRepresentation);
      this.paintImage(this.params);
      this.writeTitle(this.params);
      this.writeSubtitle(this.params);
      if (this.template.hasImageCaption()) {
         this.writeCaption(this.params);
      }

      return frontPageImageRepresentation;
   }

   /**
    * Reads background image template or newspaper image template.
    *
    * @return
    * @throws IOException
    */
   private BufferedImage getFrontPageImageRepresentation() {
      try {
         return ImageIO.read(new File(this.backgroundTemplate.getPath()));
      } catch (final IOException e) {
         throw new SystemException("Application Error. Fail to read background file at: " + this.backgroundTemplate.getPath() + " Try to "
                  + "reinstall the application from scratch.", e);
      }
   }

   /**
    * Creates internal graphics {@link #frontPageGraphics} and configures it.
    *
    * @param frontPage buffered image to creates graphics from.
    *
    */
   private void createGraphics(final BufferedImage frontPage) {
      this.frontPageGraphics = frontPage.createGraphics();
      this.frontPageGraphics.addRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
               RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
      this.frontPageGraphics.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY));
   }

   /**
    * Writes title section
    *
    * @param params
    */
   private void writeTitle(final FrontPageInstanceParams params) {
      final Font font = this.calculateTitleFont(params);
      final TextSection titleSection = this.template.getTitleSection();
      this.writeTextTo(params.getTile(), font, titleSection.getTextCoordinates(), titleSection.getTextWidth(),
               titleSection.getTextLeading());
   }

   /**
    * Calculates best font to use for title section.
    *
    * @param params
    * @return
    */
   private Font calculateTitleFont(final FrontPageInstanceParams params) {
      final Integer fontSize = this.calculateTitleFontSize(params.getTile());
      final TextSectionFont textFont = this.template.getTitleSection().getTextFont();

      return new Font(textFont.getFontName(), textFont.getFontStyle(), fontSize);
   }

   /**
    * Returns font size to use for title given text title. It "tests" writing text and checking how many lines was made.
    *
    * @return
    */
   private Integer calculateTitleFontSize(final String title) {
      final TextSection titleSection = this.template.getTitleSection();
      final TextSectionFont textFont = titleSection.getTextFont();
      final Font testingFont = new Font(textFont.getFontName(), textFont.getFontStyle(), textFont.getSmallSize());

      final Double linesUsingBigFontSize =
               testingFont.getStringBounds(title, this.frontPageGraphics.getFontRenderContext()).getWidth()
                        / titleSection.getTextWidth();
      if (linesUsingBigFontSize > 2) {
         return textFont.getSmallSize();
      } else {
         return textFont.getBigSize();
      }
   }

   /**
    * Writes caption section.
    *
    * @param params
    */
   private void writeCaption(final FrontPageInstanceParams params) {
      this.writeToSectionUsingSmallFont(this.template.getImageCaption(), params.getCaption());
   }

   /**
    * Write subtitle section
    *
    * @param params
    */
   private void writeSubtitle(final FrontPageInstanceParams params) {
      this.writeToSectionUsingSmallFont(this.template.getSubtitleSection(), params.getSubtitle());
   }

   /**
    * Writes text on specific {@link TextSection} using {@link TextSection} small font only
    * @param section
    * @param text
    */
   private void writeToSectionUsingSmallFont(final TextSection section, final String text) {
      final TextSectionFont textFont = section.getTextFont();
      final Font font = new Font(textFont.getFontName(), textFont.getFontStyle(), textFont.getSmallSize());
      this.writeTextTo(text, font, section.getTextCoordinates(), section.getTextWidth(), section.getTextLeading());
   }

   /**
    * Prints image in background template.
    *
    * @param params
    */
   private void paintImage(final FrontPageInstanceParams params) {
      final BufferedImage image = params.getImage();
      final TwoDimensionsValues pictureScale = this.backgroundTemplate.getPictureScale();
      final TwoDimensionsValues pictureCoordinates = this.backgroundTemplate.getPictureCoordinates();
      final Image scaledPhoto = image.getScaledInstance(pictureScale.getX(), pictureScale.getY(), Image.SCALE_SMOOTH);

      this.frontPageGraphics.drawImage(scaledPhoto, pictureCoordinates.getX(), pictureCoordinates.getY(), null);
   }

   /**
    * Writes text to given coordinates
    *
    * @param inputText text to write
    * @param font to use
    * @param coordinates where write
    * @param width horizontal boundaries
    * @param leading text leading property
    */
   private void writeTextTo(final String inputText, final Font font, final TwoDimensionsValues coordinates, final int width,
            final int leading) {
      final AttributedString as = new AttributedString(inputText);
      as.addAttribute(TextAttribute.FONT, font);
      as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);

      final AttributedCharacterIterator characterIterator = as.getIterator();
      final FontRenderContext fontRenderContext = this.frontPageGraphics.getFontRenderContext();
      final LineBreakMeasurer measurer = new LineBreakMeasurer(characterIterator, fontRenderContext);

      int verticalTempCoordinate = coordinates.getY();
      while (measurer.getPosition() < characterIterator.getEndIndex()) {
         final TextLayout textLayout = measurer.nextLayout(width);
         verticalTempCoordinate += textLayout.getAscent() + leading;
         textLayout.draw(this.frontPageGraphics, coordinates.getX(), verticalTempCoordinate);
         verticalTempCoordinate += textLayout.getDescent() + leading;
      }
   }

}
