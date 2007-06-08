/*
    Copyright (c) 2005-2007, Paul Richards
    All rights reserved.

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions are met:

        * Redistributions of source code must retain the above copyright notice,
        this list of conditions and the following disclaimer.

        * Redistributions in binary form must reproduce the above copyright
        notice, this list of conditions and the following disclaimer in the
        documentation and/or other materials provided with the distribution.

        * Neither the name of Paul Richards nor the names of contributors may be
        used to endorse or promote products derived from this software without
        specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
    AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
    IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
    ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
    LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
    CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
    SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
    INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
    CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
    ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
    POSSIBILITY OF SUCH DAMAGE.
*/

package pigeon.view;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;
import pigeon.About;
import pigeon.competitions.Competition;
import pigeon.model.Member;
import pigeon.model.Race;
import pigeon.model.Racepoint;
import pigeon.model.Season;
import pigeon.model.ValidationException;
import pigeon.report.CompetitionReporter;
import pigeon.report.DistanceReporter;
import pigeon.report.MembersReporter;
import pigeon.report.RaceReporter;
import pigeon.report.Reporter;
import pigeon.view.laf.BigFontTheme;

/**
    Application entry point and top level window.

    All top level windows exist in here and are switched between using the card layout.
*/
final class MainWindow extends javax.swing.JFrame {

    private static final long serialVersionUID = 8988408906488593901L;

    private final Configuration configuration;
    private Season season;
    private File currentlyLoadedFile;

    public MainWindow(Configuration configuration) {
        this.configuration = configuration;
        initComponents();
        raceresultsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {
                refreshButtons();
            }
        });     
        setIconImage(getIcon());
        setTitle(About.TITLE);
        setSeason(null, "mainMenu");
    }

    private static Image getIcon()
    {
        try {
            InputStream in = ClassLoader.getSystemResourceAsStream("resources/Icon.png");
            if (in != null) {
                Image image = ImageIO.read(in);
                return image;
            }
        } catch (IOException e) {
        }
        return null;
    }

    private static Configuration loadConfiguration() throws IOException
    {
        InputStream in = ClassLoader.getSystemResourceAsStream("configuration.xml");
        return new Configuration(in);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        mainMenuPanel = new javax.swing.JPanel();
        loadSeasonButton = new javax.swing.JButton();
        newSeasonButton = new javax.swing.JButton();
        setupClubPanel = new javax.swing.JPanel();
        finishedButton = new javax.swing.JButton();
        organizationPanel = new javax.swing.JPanel();
        clubNameLabel = new javax.swing.JLabel();
        clubNameText = new javax.swing.JTextField();
        membersPanel = new javax.swing.JPanel();
        memberListScrollPane = new javax.swing.JScrollPane();
        membersList = new javax.swing.JList();
        memberButtonPanel = new javax.swing.JPanel();
        memberAddButton = new javax.swing.JButton();
        memberEditButton = new javax.swing.JButton();
        memberDeleteButton = new javax.swing.JButton();
        racepointsPanel = new javax.swing.JPanel();
        racepointListScrollPane = new javax.swing.JScrollPane();
        racepointsList = new javax.swing.JList();
        racepointButtonPanel = new javax.swing.JPanel();
        racepointAddButton = new javax.swing.JButton();
        racepointEditButton = new javax.swing.JButton();
        racepointDeleteButton = new javax.swing.JButton();
        viewingSeason = new javax.swing.JPanel();
        raceresultPanel = new javax.swing.JPanel();
        raceresultListScrollPane = new javax.swing.JScrollPane();
        raceresultsTable = new javax.swing.JTable();
        raceresultButtonPanel = new javax.swing.JPanel();
        raceresultAddButton = new javax.swing.JButton();
        raceresultEditButton = new javax.swing.JButton();
        raceresultDeleteButton = new javax.swing.JButton();
        raceresultCalculateResultsButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openItem = new javax.swing.JMenuItem();
        closeItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        reportsMenu = new javax.swing.JMenu();
        viewMembersItem = new javax.swing.JMenuItem();
        menuSeparator1 = new javax.swing.JSeparator();
        viewMemberDistancesItem = new javax.swing.JMenuItem();
        viewRacepointDistancesItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutItem = new javax.swing.JMenuItem();

        getContentPane().setLayout(new java.awt.CardLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pigeon");
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        mainMenuPanel.setLayout(new java.awt.GridBagLayout());

        loadSeasonButton.setText("Load existing season");
        loadSeasonButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loadSeasonButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        mainMenuPanel.add(loadSeasonButton, gridBagConstraints);

        newSeasonButton.setText("Start new season");
        newSeasonButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newSeasonButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        mainMenuPanel.add(newSeasonButton, gridBagConstraints);

        getContentPane().add(mainMenuPanel, "mainMenu");

        setupClubPanel.setLayout(new java.awt.GridBagLayout());

        finishedButton.setText("Finished");
        finishedButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                finishedButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        setupClubPanel.add(finishedButton, gridBagConstraints);

        organizationPanel.setLayout(new java.awt.GridBagLayout());

        organizationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Organisation Information"));
        clubNameLabel.setText("Organisation Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        organizationPanel.add(clubNameLabel, gridBagConstraints);

        clubNameText.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                clubNameTextFocusLost(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        organizationPanel.add(clubNameText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        setupClubPanel.add(organizationPanel, gridBagConstraints);

        membersPanel.setLayout(new java.awt.BorderLayout());

        membersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Member Information"));
        membersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        membersList.setVisibleRowCount(12);
        membersList.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                membersListValueChanged(evt);
            }
        });

        memberListScrollPane.setViewportView(membersList);

        membersPanel.add(memberListScrollPane, java.awt.BorderLayout.CENTER);

        memberAddButton.setText("Add Member");
        memberAddButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                memberAddButtonActionPerformed(evt);
            }
        });

        memberButtonPanel.add(memberAddButton);

        memberEditButton.setText("Edit Member");
        memberEditButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                memberEditButtonActionPerformed(evt);
            }
        });

        memberButtonPanel.add(memberEditButton);

        memberDeleteButton.setText("Delete Member");
        memberDeleteButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                memberDeleteButtonActionPerformed(evt);
            }
        });

        memberButtonPanel.add(memberDeleteButton);

        membersPanel.add(memberButtonPanel, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        setupClubPanel.add(membersPanel, gridBagConstraints);

        racepointsPanel.setLayout(new java.awt.BorderLayout());

        racepointsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Racepoint Information"));
        racepointsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        racepointsList.setVisibleRowCount(6);
        racepointsList.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                racepointsListValueChanged(evt);
            }
        });

        racepointListScrollPane.setViewportView(racepointsList);

        racepointsPanel.add(racepointListScrollPane, java.awt.BorderLayout.CENTER);

        racepointAddButton.setText("Add Racepoint");
        racepointAddButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                racepointAddButtonActionPerformed(evt);
            }
        });

        racepointButtonPanel.add(racepointAddButton);

        racepointEditButton.setText("Edit Racepoint");
        racepointEditButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                racepointEditButtonActionPerformed(evt);
            }
        });

        racepointButtonPanel.add(racepointEditButton);

        racepointDeleteButton.setText("Delete Racepoint");
        racepointDeleteButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                racepointDeleteButtonActionPerformed(evt);
            }
        });

        racepointButtonPanel.add(racepointDeleteButton);

        racepointsPanel.add(racepointButtonPanel, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        setupClubPanel.add(racepointsPanel, gridBagConstraints);

        getContentPane().add(setupClubPanel, "setupClub");

        viewingSeason.setLayout(new java.awt.GridBagLayout());

        raceresultPanel.setLayout(new java.awt.BorderLayout());

        raceresultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Races"));
        raceresultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        raceresultListScrollPane.setViewportView(raceresultsTable);

        raceresultPanel.add(raceresultListScrollPane, java.awt.BorderLayout.CENTER);

        raceresultButtonPanel.setLayout(new java.awt.GridBagLayout());

        raceresultAddButton.setText("Add Race");
        raceresultAddButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                raceresultAddButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        raceresultButtonPanel.add(raceresultAddButton, gridBagConstraints);

        raceresultEditButton.setText("Edit Race");
        raceresultEditButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                raceresultEditButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        raceresultButtonPanel.add(raceresultEditButton, gridBagConstraints);

        raceresultDeleteButton.setText("Delete Race");
        raceresultDeleteButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                raceresultDeleteButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        raceresultButtonPanel.add(raceresultDeleteButton, gridBagConstraints);

        raceresultCalculateResultsButton.setText("Calculate Results");
        raceresultCalculateResultsButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                raceresultCalculateResultsButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        raceresultButtonPanel.add(raceresultCalculateResultsButton, gridBagConstraints);

        raceresultPanel.add(raceresultButtonPanel, java.awt.BorderLayout.EAST);

        jLabel1.setText("Add races to the season below.");
        raceresultPanel.add(jLabel1, java.awt.BorderLayout.NORTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        viewingSeason.add(raceresultPanel, gridBagConstraints);

        getContentPane().add(viewingSeason, "viewingSeason");

        fileMenu.setText("File");
        openItem.setText("Open");
        openItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openItemActionPerformed(evt);
            }
        });

        fileMenu.add(openItem);

        closeItem.setText("Close");
        closeItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                closeItemActionPerformed(evt);
            }
        });

        fileMenu.add(closeItem);

        saveItem.setText("Save");
        saveItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveItemActionPerformed(evt);
            }
        });

        fileMenu.add(saveItem);

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitItemActionPerformed(evt);
            }
        });

        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        reportsMenu.setText("Reports");
        viewMembersItem.setText("View Members");
        viewMembersItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                viewMembersItemActionPerformed(evt);
            }
        });

        reportsMenu.add(viewMembersItem);

        reportsMenu.add(menuSeparator1);

        viewMemberDistancesItem.setText("View Distances for a Member");
        viewMemberDistancesItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                viewMemberDistancesItemActionPerformed(evt);
            }
        });

        reportsMenu.add(viewMemberDistancesItem);

        viewRacepointDistancesItem.setText("View Distances for a Racepoint");
        viewRacepointDistancesItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                viewRacepointDistancesItemActionPerformed(evt);
            }
        });

        reportsMenu.add(viewRacepointDistancesItem);

        menuBar.add(reportsMenu);

        helpMenu.setText("Help");
        aboutItem.setText("About");
        aboutItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                aboutItemActionPerformed(evt);
            }
        });

        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewMembersItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewMembersItemActionPerformed
    {//GEN-HEADEREND:event_viewMembersItemActionPerformed
        MembersReporter reporter = new MembersReporter(
            season.getOrganization().toString(),
            season.getOrganization().getMembers(),
            configuration.getMode()
        );

        writeReport("Members", reporter);
    }//GEN-LAST:event_viewMembersItemActionPerformed

    private void racepointsListValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_racepointsListValueChanged
    {//GEN-HEADEREND:event_racepointsListValueChanged
        refreshButtons();
    }//GEN-LAST:event_racepointsListValueChanged

    private void membersListValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_membersListValueChanged
    {//GEN-HEADEREND:event_membersListValueChanged
        refreshButtons();
    }//GEN-LAST:event_membersListValueChanged

    private void writeReport(String type, Reporter reporter)
    {
        try {
            File outputFile = File.createTempFile(type, ".html");
            FileOutputStream fileOut = null;
            try {
                fileOut = new FileOutputStream(outputFile);
                OutputStream stream = new BufferedOutputStream(fileOut);
                reporter.write(stream);
                stream.close();
            } finally {
                if (fileOut != null) {
                    fileOut.close();
                }
            }
            com.centerkey.utils.BareBonesBrowserLaunch.openURL(outputFile.toURI().toURL().toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(getContentPane(), e.toString());
        }
    }
    
    private void viewRacepointDistancesItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewRacepointDistancesItemActionPerformed
    {//GEN-HEADEREND:event_viewRacepointDistancesItemActionPerformed
        JComboBox racepointList = new JComboBox();
        racepointList.setEditable(false);
        for (Racepoint r: season.getOrganization().getRacepoints()) {
            racepointList.addItem(r);
        }
        int choice = JOptionPane.showConfirmDialog(getContentPane(), racepointList, "Select a racepoint", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.OK_OPTION) {
            Racepoint racepoint = (Racepoint)racepointList.getSelectedItem();
            DistanceReporter<Member> reporter = new DistanceReporter<Member>(
                season.getOrganization().toString(),
                racepoint.toString(),
                "Member",
                season.getOrganization().getDistancesForRacepoint(racepoint)
            );

            writeReport("RacepointDistances", reporter);
        }
    }//GEN-LAST:event_viewRacepointDistancesItemActionPerformed

    private void viewMemberDistancesItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_viewMemberDistancesItemActionPerformed
    {//GEN-HEADEREND:event_viewMemberDistancesItemActionPerformed
        JComboBox memberList = new JComboBox();
        memberList.setEditable(false);
        for (Member m: season.getOrganization().getMembers()) {
            memberList.addItem(m);
        }
        int choice = JOptionPane.showConfirmDialog(getContentPane(), memberList, "Select a member", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (choice == JOptionPane.OK_OPTION) {
            Member member = (Member)memberList.getSelectedItem();
            DistanceReporter<Racepoint> reporter = new DistanceReporter<Racepoint>(
                season.getOrganization().toString(),
                member.toString(),
                "Racepoint",
                season.getOrganization().getDistancesForMember(member)
            );

            writeReport("MemberDistances", reporter);
        }
    }//GEN-LAST:event_viewMemberDistancesItemActionPerformed

    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
        JTextArea widget = new JTextArea(About.TITLE + ".\n\n" + About.getLicense() + "\n\n" + About.CREDITS);
        widget.setEditable(false);
        JOptionPane.showMessageDialog(
            this,
            new JScrollPane(widget),
            About.TITLE,
            JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_aboutItemActionPerformed

    private void raceresultCalculateResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raceresultCalculateResultsButtonActionPerformed
        int index = raceresultsTable.getSelectedRow();
        Race race = season.getRaces().get(index);
        boolean listClubNames = configuration.getMode() == Configuration.Mode.FEDERATION;
        
        JCheckBox raceReport = new JCheckBox("Race results", true);
        JCheckBox poolsReport = new JCheckBox("Pool results", true);
        JPanel options = new JPanel();
        options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
        options.add(raceReport);
        options.add(poolsReport);
        
        int result = JOptionPane.showConfirmDialog(
            this,
            options,
            "Results",
            JOptionPane.OK_CANCEL_OPTION);
        
        try {
            if (result == JOptionPane.OK_OPTION) {
                if (raceReport.isSelected()) {
                    writeReport("RaceResults", new RaceReporter(season.getOrganization(), race, listClubNames));
                }
                if (poolsReport.isSelected()) {
                    Map<String, Map<String, JTextField>> textFieldMap = new TreeMap<String, Map<String, JTextField>>();
                    JPanel panel = constructCompetitionEntrantCountPanel(textFieldMap, race);

                    int dialogResult = JOptionPane.showConfirmDialog(
                        this,
                        panel,
                        "Entrants",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                    if (dialogResult == JOptionPane.OK_OPTION) {
                        Map<String, Map<String, Integer>> entrantsCount = new TreeMap<String, Map<String, Integer>>();
                        for (Map.Entry<String, Map<String, JTextField>> i: textFieldMap.entrySet()) {
                            entrantsCount.put(i.getKey(), new TreeMap<String, Integer>());
                            for (Map.Entry<String, JTextField> j: i.getValue().entrySet()) {
                                int entrants = NumberFormat.getIntegerInstance().parse(j.getValue().getText()).intValue();
                                entrantsCount.get(i.getKey()).put(j.getKey(), entrants);
                            }
                        }
                        writeReport("PoolResults", new CompetitionReporter(
                            season.getOrganization(),
                            race,
                            listClubNames,
                            configuration.getCompetitions(),
                            entrantsCount));
                    }
                }
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(getContentPane(), e.toString());            
        }
    }//GEN-LAST:event_raceresultCalculateResultsButtonActionPerformed

    private JPanel constructCompetitionEntrantCountPanel(Map<String, Map<String, JTextField>> textFieldMap, Race race) throws IllegalArgumentException
    {
        JPanel panel = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        
        List<String> sections = pigeon.report.Utilities.participatingSections(race);
        if (sections.contains("Open")) {
            throw new IllegalArgumentException("Arg!  A section called 'Open' has been used, that's too confusing!");
        }
        sections.add(0, "Open");
        
        for (String section: sections) {
            textFieldMap.put(section, new TreeMap<String, JTextField>());
            
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.fill = GridBagConstraints.NONE;
            constraints.weightx = 1.0;
            constraints.gridwidth = 2;
            if (section == sections.get(sections.size() - 1)) {
                constraints.gridwidth = GridBagConstraints.REMAINDER;
            }
            JLabel label = new JLabel(section);
            gridbag.setConstraints(label, constraints);
            panel.add(label);
        }
        
        for (Competition c: configuration.getCompetitions()) {
            for (String section: sections) {
                constraints.anchor = GridBagConstraints.EAST;
                constraints.fill = GridBagConstraints.NONE;
                constraints.weightx = 0.0;
                constraints.gridwidth = 1;
                JLabel label = new JLabel(c.getName());
                gridbag.setConstraints(label, constraints);
                panel.add(label);

                constraints.anchor = GridBagConstraints.WEST;
                constraints.fill = GridBagConstraints.HORIZONTAL;
                constraints.weightx = 1.0;
                constraints.gridwidth = 1;
                if (section == sections.get(sections.size() - 1)) {
                    constraints.gridwidth = GridBagConstraints.REMAINDER;
                }
                JTextField field = new JFormattedTextField(NumberFormat.getIntegerInstance());
                field.setColumns(4);
                gridbag.setConstraints(field, constraints);
                panel.add(field);
                
                textFieldMap.get(section).put(c.getName(), field);
            }
        }
        return panel;
    }

    private void clubNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_clubNameTextFocusLost
        try {
            String clubName = clubNameText.getText();
            season.getOrganization().setName(clubName);
        } catch (ValidationException e) {
        }
    }//GEN-LAST:event_clubNameTextFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            closeFile();
            dispose();
        } catch (UserCancelledException e) {
        }
    }//GEN-LAST:event_formWindowClosing

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitItemActionPerformed
    {//GEN-HEADEREND:event_exitItemActionPerformed
        try {
            closeFile();
            dispose();
        } catch (UserCancelledException e) {
        }
    }//GEN-LAST:event_exitItemActionPerformed

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveItemActionPerformed
    {//GEN-HEADEREND:event_saveItemActionPerformed
        try {
            promptSaveSeason();
        } catch (UserCancelledException e) {
        }
    }//GEN-LAST:event_saveItemActionPerformed

    private void closeItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_closeItemActionPerformed
    {//GEN-HEADEREND:event_closeItemActionPerformed
        try {
            closeFile();
            switchToCard("mainMenu");
        } catch (UserCancelledException e) {
        }
    }//GEN-LAST:event_closeItemActionPerformed

    private void openItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openItemActionPerformed
    {//GEN-HEADEREND:event_openItemActionPerformed
        try {
            closeFile();
            promptLoadSeason();
        } catch (UserCancelledException e) {
        }
    }//GEN-LAST:event_openItemActionPerformed

    private void raceresultDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raceresultDeleteButtonActionPerformed
        int index = raceresultsTable.getSelectedRow();
        Race race = season.getRaces().get(index);
        season.removeRace(race);
        reloadRacesTable();
    }//GEN-LAST:event_raceresultDeleteButtonActionPerformed

    private void raceresultEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raceresultEditButtonActionPerformed
        int index = raceresultsTable.getSelectedRow();
        Race race = season.getRaces().get(index);
        try {
            RaceSummary.editRace(this, race, season.getOrganization(), false);
            editResultsForRace( race );
        } catch (UserCancelledException e) {
        }
        reloadRacesTable();
    }//GEN-LAST:event_raceresultEditButtonActionPerformed

    private void raceresultAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raceresultAddButtonActionPerformed
        try {
            Race race = RaceSummary.createRace(this, season.getOrganization());
            season.addRace( race );
            try {
                editResultsForRace( race );
            } catch (UserCancelledException e) {
                season.removeRace( race );
                throw e;
            }
        } catch (UserCancelledException ex) {
        } catch (ValidationException e) {
            e.displayErrorDialog(this);
        }
        reloadRacesTable();
    }//GEN-LAST:event_raceresultAddButtonActionPerformed

    private void editResultsForRace(Race race) throws UserCancelledException
    {
        Component parent = this.getContentPane();
        RaceEditor.editRaceResults(parent, race, season.getOrganization(), configuration);
    }

    private void loadSeasonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadSeasonButtonActionPerformed
        promptLoadSeason();
    }//GEN-LAST:event_loadSeasonButtonActionPerformed

    private void finishedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishedButtonActionPerformed
        try {
            String clubName = clubNameText.getText();
            season.getOrganization().setName(clubName);

            int memberCount = season.getOrganization().getNumberOfMembers();
            int racepointCount = season.getOrganization().getNumberOfRacepoints();
            String message =
                    "Have you finished adding all of the members (total of " + memberCount + ") " +
                    "and racepoints (total of " + racepointCount + ") for the " +
                    "organisation \"" + season.getOrganization().getName() + "\"?";
            int result = JOptionPane.showConfirmDialog(this, message, "Finishing organisation setup", JOptionPane.YES_NO_OPTION);
            switch (result) {
                case JOptionPane.YES_OPTION:
                    promptSaveSeason();
                    switchToCard("viewingSeason");
                    break;
                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(this, "Please continue to add members and racepoints.");
                    break;
                default:
                    throw new IllegalStateException();
            }
        } catch (ValidationException e) {
            e.displayErrorDialog(getContentPane());
        } catch (UserCancelledException e) {
        }
    }//GEN-LAST:event_finishedButtonActionPerformed

    private void promptSaveSeason() throws UserCancelledException {
        if (currentlyLoadedFile != null) {
             try {
                writeSeasonToFile(currentlyLoadedFile);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, e.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e.toString());
            }
       } else {
            try {
                JFileChooser chooser = new JFileChooser();
                FileFilter filter = SimpleFileFilter.createSeasonFileFilter();
                chooser.addChoosableFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                while (true) {
                    int result = chooser.showSaveDialog(this);
                    switch (result) {
                        case JFileChooser.APPROVE_OPTION:
                            File file = chooser.getSelectedFile();
                            if (!file.getName().endsWith(".pcs")) {
                                file = new File(file.getParentFile(), file.getName() + ".pcs");
                            }
                            try {
                                writeSeasonToFile(file);
                            } catch (FileNotFoundException e) {
                                JOptionPane.showMessageDialog(this, e.toString());
                            } catch (IOException e) {
                                JOptionPane.showMessageDialog(this, e.toString());
                            }
                            return;
                        case JFileChooser.CANCEL_OPTION:
                            throw new UserCancelledException();
                        case JFileChooser.ERROR_OPTION:
                        default:
                            throw new IllegalStateException();
                    }
                }
            } catch (UserCancelledException e) {
            }
        }
    }

    private void promptLoadSeason() {
        JFileChooser chooser = new JFileChooser();
        FileFilter filter = SimpleFileFilter.createSeasonFileFilter();
        chooser.addChoosableFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        int result = chooser.showOpenDialog(this);
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                File file = chooser.getSelectedFile();
                try {
                    Season loaded = loadSeasonFromFile(file);
                    currentlyLoadedFile = file;
                    if (loaded.getRaces().isEmpty()) {
                        setSeason(loaded, "setupClub");
                    } else {
                        setSeason(loaded, "viewingSeason");
                    }
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(this, e.toString());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, e.toString());
                } catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(this, e.toString());
                }
                break;
            case JFileChooser.CANCEL_OPTION:
                break;
            case JFileChooser.ERROR_OPTION:
            default:
                throw new IllegalStateException();
        }
    }

    private void writeSeasonToFile(File file) throws FileNotFoundException, IOException {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(file);
            ObjectOutput objectOut = new ObjectOutputStream(new GZIPOutputStream(new BufferedOutputStream(fileOut)));
            objectOut.writeObject(season);
            objectOut.close();
            currentlyLoadedFile = file;
            JOptionPane.showMessageDialog(getContentPane(), "Saved to " + file.toString());
        } finally {
            if (fileOut != null) {
                fileOut.close();
            }
        }
    }

    private static Season loadSeasonFromFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(file);
            ObjectInput objectIn = new ObjectInputStream(new GZIPInputStream(new BufferedInputStream(fileIn)));
            Season loaded = (Season)objectIn.readObject();
            objectIn.close();
            return loaded;
        } finally {
            if (fileIn != null) {
                fileIn.close();
            }
        }
    }


    private void racepointDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_racepointDeleteButtonActionPerformed
        Racepoint racepoint = (Racepoint)racepointsList.getSelectedValue();
        int result = JOptionPane.showConfirmDialog(this, "Really delete '" + racepoint + "' and all its distances?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            season.getOrganization().removeRacepoint( racepoint );
            reloadRacepointsList();
        }
    }//GEN-LAST:event_racepointDeleteButtonActionPerformed

    private void memberDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberDeleteButtonActionPerformed
        Member member = (Member)membersList.getSelectedValue();
        int result = JOptionPane.showConfirmDialog(this, "Really delete '" + member + "' and all their distances?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            season.getOrganization().removeMember( member );
            reloadMembersList();
        }
    }//GEN-LAST:event_memberDeleteButtonActionPerformed

    private void racepointEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_racepointEditButtonActionPerformed
        int index = racepointsList.getSelectedIndex();
        Racepoint racepoint = season.getOrganization().getRacepoints().get(index);
        String name = JOptionPane.showInputDialog(this, "Please enter a new name for \"" + racepoint + "\"", "Edit racepoint name", JOptionPane.QUESTION_MESSAGE,null,null, racepoint.toString()).toString();
        if (name != null) {
            try {
                String oldName = racepoint.getName();
                racepoint.setName( name );
                try {
                    editDistancesForRacepoint( racepoint );
                } catch (UserCancelledException e) {
                    racepoint.setName( oldName );
                    throw e;
                }
            } catch (UserCancelledException e) {
            } catch (ValidationException e) {
                e.displayErrorDialog(this);
            }
            reloadRacepointsList();
        }
    }//GEN-LAST:event_racepointEditButtonActionPerformed

    private void memberEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberEditButtonActionPerformed
        int index = membersList.getSelectedIndex();
        Member member = season.getOrganization().getMembers().get(index);
        try {
            MemberInfo.editMember(this, member, season.getOrganization(), false, configuration.getMode());
            editDistancesForMember( member );
        } catch (UserCancelledException e) {
        }
        reloadMembersList();
    }//GEN-LAST:event_memberEditButtonActionPerformed

    private void racepointAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_racepointAddButtonActionPerformed
         String name = JOptionPane.showInputDialog(this, "Please enter a name", "New racepoint", JOptionPane.QUESTION_MESSAGE);
         if (name != null) {
             try {
                 Racepoint racepoint = new Racepoint();
                 racepoint.setName(name);
                 season.getOrganization().addRacepoint( racepoint );
                 try {
                     editDistancesForRacepoint( racepoint );
                 } catch (UserCancelledException e) {
                     season.getOrganization().removeRacepoint(racepoint);
                     throw e;
                 }
             } catch (UserCancelledException e) {
             } catch (ValidationException e) {
                 e.displayErrorDialog(this);
             }
             reloadRacepointsList();
         }
    }//GEN-LAST:event_racepointAddButtonActionPerformed

    private void memberAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberAddButtonActionPerformed
        try {
            Member member = MemberInfo.createMember(this, season.getOrganization(), configuration.getMode());
            season.getOrganization().addMember( member );
            try {
                editDistancesForMember( member );
            } catch (UserCancelledException e) {
                season.getOrganization().removeMember( member );
                throw e;
            }
        } catch (UserCancelledException e) {
        } catch (ValidationException e) {
            e.displayErrorDialog(this);
        }
        reloadMembersList();
    }//GEN-LAST:event_memberAddButtonActionPerformed

    private void reloadControlData() {
        if (season != null) {
            clubNameText.setText(season.getOrganization().getName());
            reloadMembersList();
            reloadRacepointsList();
            reloadRacesTable();
        }
        refreshButtons();
        refreshMenus();
    }

    private void reloadMembersList() {
        membersList.setListData(season.getOrganization().getMembers().toArray());
    }

    private void reloadRacepointsList() {
        racepointsList.setListData(season.getOrganization().getRacepoints().toArray());
    }

    private void reloadRacesTable() {
        RacesTableModel model = new RacesTableModel(season.getRaces());
        raceresultsTable.setModel(model);
    }

    private void refreshButtons() {
        memberEditButton.setEnabled( membersList.getSelectedIndex() != -1 );
        memberDeleteButton.setEnabled( membersList.getSelectedIndex() != -1 );
        
        racepointEditButton.setEnabled( racepointsList.getSelectedIndex() != -1 );
        racepointDeleteButton.setEnabled( racepointsList.getSelectedIndex() != -1 );
        
        raceresultEditButton.setEnabled( raceresultsTable.getSelectedRow() != -1 );
        raceresultDeleteButton.setEnabled( raceresultsTable.getSelectedRow() != -1 );
        raceresultCalculateResultsButton.setEnabled( raceresultsTable.getSelectedRow() != -1 );
    }
    
    private void refreshMenus() {
        saveItem.setEnabled(season != null);
        closeItem.setEnabled(season != null);
        reportsMenu.setEnabled(season != null);
    }

    private void switchToCard(String cardName) {
        Container parent = this.getContentPane();
        ((CardLayout)parent.getLayout()).show(parent, cardName);
        reloadControlData();
    }

    private void newSeasonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSeasonButtonActionPerformed
        setSeason(new Season(), "setupClub");
    }//GEN-LAST:event_newSeasonButtonActionPerformed

    private void editDistancesForMember(Member member) throws UserCancelledException {
        Component parent = this.getContentPane();
        DistanceEditor.editMemberDistances(parent, member, season.getOrganization());
    }

    private void editDistancesForRacepoint(Racepoint racepoint) throws UserCancelledException {
        Component parent = this.getContentPane();
        DistanceEditor.editRacepointDistances(parent, racepoint, season.getOrganization());
    }

    private static void delayForSplashScreen() throws InterruptedException
    {
        // The splash screen defined in the Jar manifest file is only
        // present when we have Java 6 or better
        final String javaVersion = System.getProperty("java.version");
        if (javaVersion.compareTo("1.6") >= 0) {
            Thread.sleep(3000);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, InterruptedException
    {
        ExceptionHandler.register();
        checkAssertions();
        setSwingLAF();

        Configuration configuration = loadConfiguration();
        Configuration.Mode m = configuration.getMode();
        MainWindow window = new MainWindow(configuration);
        window.setLocationRelativeTo(null);
        delayForSplashScreen();
        window.setVisible(true);
    }

    /**
        Switches to a new Season object, and move to the specified screen.
    */
    private void setSeason(Season season, String cardName)
    {
        try {
            if (season != null) {
                Utilities.validateSeason(season, configuration);
            }
            this.season = season;
            switchToCard(cardName);
        } catch (ValidationException e) {
            e.displayErrorDialog(this.getContentPane());
            setSeason(null, "mainMenu");
        }
    }

    private static void checkAssertions() {
        boolean assertsEnabled = false;
        assert assertsEnabled = true; // Intentional side effect!!!
        if (!assertsEnabled) {
            System.err.println("WARNING: Assertions are not enabled.");
        }
    }

    private static void setSwingLAF() {
        try {
            MetalLookAndFeel.setCurrentTheme(new BigFontTheme(1.22f));
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void closeFile() throws UserCancelledException {
        if (this.season != null) {
            int result = JOptionPane.showConfirmDialog(this, "Save changes before closing?", "Save changes", JOptionPane.YES_NO_OPTION);
            switch (result) {
                case JOptionPane.YES_OPTION:
                    promptSaveSeason();
                    break;
                case JOptionPane.NO_OPTION:
                    break;
                default:
                    throw new IllegalStateException();
            }
            setSeason(null, "mainMenu");
            this.currentlyLoadedFile = null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JMenuItem closeItem;
    private javax.swing.JLabel clubNameLabel;
    private javax.swing.JTextField clubNameText;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton finishedButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loadSeasonButton;
    private javax.swing.JPanel mainMenuPanel;
    private javax.swing.JButton memberAddButton;
    private javax.swing.JPanel memberButtonPanel;
    private javax.swing.JButton memberDeleteButton;
    private javax.swing.JButton memberEditButton;
    private javax.swing.JScrollPane memberListScrollPane;
    private javax.swing.JList membersList;
    private javax.swing.JPanel membersPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JSeparator menuSeparator1;
    private javax.swing.JButton newSeasonButton;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JPanel organizationPanel;
    private javax.swing.JButton racepointAddButton;
    private javax.swing.JPanel racepointButtonPanel;
    private javax.swing.JButton racepointDeleteButton;
    private javax.swing.JButton racepointEditButton;
    private javax.swing.JScrollPane racepointListScrollPane;
    private javax.swing.JList racepointsList;
    private javax.swing.JPanel racepointsPanel;
    private javax.swing.JButton raceresultAddButton;
    private javax.swing.JPanel raceresultButtonPanel;
    private javax.swing.JButton raceresultCalculateResultsButton;
    private javax.swing.JButton raceresultDeleteButton;
    private javax.swing.JButton raceresultEditButton;
    private javax.swing.JScrollPane raceresultListScrollPane;
    private javax.swing.JPanel raceresultPanel;
    private javax.swing.JTable raceresultsTable;
    private javax.swing.JMenu reportsMenu;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JPanel setupClubPanel;
    private javax.swing.JMenuItem viewMemberDistancesItem;
    private javax.swing.JMenuItem viewMembersItem;
    private javax.swing.JMenuItem viewRacepointDistancesItem;
    private javax.swing.JPanel viewingSeason;
    // End of variables declaration//GEN-END:variables

}
