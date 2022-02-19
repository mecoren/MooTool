package com.luoboduner.moo.tool.ui.form.func;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.luoboduner.moo.tool.App;
import com.luoboduner.moo.tool.ui.component.RegexSyntaxTextViewer;
import com.luoboduner.moo.tool.ui.listener.func.RegexListener;
import com.luoboduner.moo.tool.util.UndoUtil;
import lombok.Getter;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

/**
 * <pre>
 * RegexForm
 * </pre>
 *
 * @author <a href="https://github.com/rememberber">RememBerBer</a>
 * @since 2019/12/13.
 */
@Getter
public class RegexForm {
    private JTabbedPane tabbedPane1;
    private JPanel regexPanel;
    private JTextField regexTextField;
    private JButton matchTestButton;
    private JButton favoriteButton;
    private JButton addToFavoriteButton;
    private JPanel contentPanel;
    private JLabel matchesLabel;

    private RegexSyntaxTextViewer textArea;
    private RTextScrollPane scrollPane;

    private static RegexForm regexForm;

    private static final Log logger = LogFactory.get();

    private RegexForm() {
        textArea = new RegexSyntaxTextViewer();
        JTextArea timeHisTextArea = TimeConvertForm.getInstance().getTimeHisTextArea();
        textArea.setSelectionColor(timeHisTextArea.getSelectionColor());
        textArea.setCaretColor(UIManager.getColor("Editor.caretColor"));
        textArea.setMarkAllHighlightColor(UIManager.getColor("Editor.markAllHighlightColor"));
        textArea.setMarkOccurrencesColor(UIManager.getColor("Editor.markOccurrencesColor"));
        textArea.setMatchedBracketBGColor(UIManager.getColor("Editor.matchedBracketBackground"));
        textArea.setMatchedBracketBorderColor(UIManager.getColor("Editor.matchedBracketBorderColor"));
        textArea.setPaintMatchedBracketPair(true);

        scrollPane = new RTextScrollPane(textArea);

        scrollPane.setMaximumSize(new Dimension(-1, -1));
        scrollPane.setMinimumSize(new Dimension(-1, -1));

        Color defaultBackground = App.mainFrame.getBackground();

        Gutter gutter = scrollPane.getGutter();
        gutter.setBorderColor(gutter.getLineNumberColor().darker());
        gutter.setBackground(defaultBackground);

        Font font = new Font(App.config.getFont(), Font.PLAIN, App.config.getFontSize());
        gutter.setLineNumberFont(font);
//            gutter.setLineNumberColor(defaultBackground);
        gutter.setFoldBackground(defaultBackground.darker());
        gutter.setArmedFoldBackground(defaultBackground);
        UndoUtil.register(this);
    }

    public static RegexForm getInstance() {
        if (regexForm == null) {
            regexForm = new RegexForm();
        }
        return regexForm;
    }

    public static void init() {
        regexForm = getInstance();
        regexForm.getContentPanel().add(regexForm.getScrollPane());

        initUi();

        RegexListener.addListeners();
    }

    private static void initUi() {
        regexForm.getRegexPanel().updateUI();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        regexPanel = new JPanel();
        regexPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1 = new JTabbedPane();
        regexPanel.add(tabbedPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(12, 12, 12, 12), -1, -1));
        tabbedPane1.addTab("匹配测试", panel1);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 5, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("正则表达式");
        panel3.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        regexTextField = new JTextField();
        panel3.add(regexTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        favoriteButton = new JButton();
        favoriteButton.setText("收藏夹");
        panel3.add(favoriteButton, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addToFavoriteButton = new JButton();
        addToFavoriteButton.setIcon(new ImageIcon(getClass().getResource("/icon/favorite.png")));
        addToFavoriteButton.setText("");
        panel3.add(addToFavoriteButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        matchTestButton = new JButton();
        matchTestButton.setText("匹配测试");
        panel3.add(matchTestButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel3.add(panel4, new GridConstraints(1, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("个匹配");
        panel4.add(label2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        matchesLabel = new JLabel();
        Font matchesLabelFont = this.$$$getFont$$$(null, Font.BOLD, -1, matchesLabel.getFont());
        if (matchesLabelFont != null) matchesLabel.setFont(matchesLabelFont);
        matchesLabel.setText("0");
        panel4.add(matchesLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel4.add(spacer1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(0, 0));
        panel1.add(contentPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("常用正则表达式", panel5);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane1.addTab("常识", panel6);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return regexPanel;
    }

}
